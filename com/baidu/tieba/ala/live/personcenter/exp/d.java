package com.baidu.tieba.ala.live.personcenter.exp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class d {
    private TextView dRA;
    private TextView dRB;
    private View dRC;
    private LinearLayout dRD;
    private LinearLayout dRE;
    private TextView dRz;
    protected Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        W(aMx());
    }

    public View aMx() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void W(View view) {
        this.dRE = (LinearLayout) view.findViewById(a.g.ala_person_center_current_exp_panel);
        this.dRz = (TextView) view.findViewById(a.g.ala_person_center_current_exp_txt);
        this.dRA = (TextView) view.findViewById(a.g.ala_person_center_current_level);
        this.dRB = (TextView) view.findViewById(a.g.ala_person_center_next_level);
        this.dRD = (LinearLayout) view.findViewById(a.g.ala_person_center_next_level_bg);
        this.dRC = view.findViewById(a.g.ala_person_center_current_level_bg);
    }

    public void i(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.dQN[i - 1];
        int i2 = i + 1;
        this.dRz.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.dRA.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.dRB.setText("");
        } else {
            this.dRB.setText(this.mContext.getResources().getString(a.i.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.dRC.getLayoutParams();
            layoutParams.width = (int) ((this.dRD.getLayoutParams().width * j) / j2);
            this.dRC.setLayoutParams(layoutParams);
        }
    }

    public void a(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.dRE);
        if (i == 1) {
            this.dRz.setAlpha(0.7f);
            this.dRz.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.dRA.setAlpha(0.7f);
            this.dRA.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.dRB.setAlpha(0.7f);
            this.dRB.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.dRC.setAlpha(0.7f);
            this.dRC.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.sdk_prc_current_level_bg));
        }
    }
}
