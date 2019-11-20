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
    private TextView dQI;
    private TextView dQJ;
    private TextView dQK;
    private View dQL;
    private LinearLayout dQM;
    private LinearLayout dQN;
    protected Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        W(aMv());
    }

    public View aMv() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void W(View view) {
        this.dQN = (LinearLayout) view.findViewById(a.g.ala_person_center_current_exp_panel);
        this.dQI = (TextView) view.findViewById(a.g.ala_person_center_current_exp_txt);
        this.dQJ = (TextView) view.findViewById(a.g.ala_person_center_current_level);
        this.dQK = (TextView) view.findViewById(a.g.ala_person_center_next_level);
        this.dQM = (LinearLayout) view.findViewById(a.g.ala_person_center_next_level_bg);
        this.dQL = view.findViewById(a.g.ala_person_center_current_level_bg);
    }

    public void i(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.dPW[i - 1];
        int i2 = i + 1;
        this.dQI.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.dQJ.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.dQK.setText("");
        } else {
            this.dQK.setText(this.mContext.getResources().getString(a.i.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.dQL.getLayoutParams();
            layoutParams.width = (int) ((this.dQM.getLayoutParams().width * j) / j2);
            this.dQL.setLayoutParams(layoutParams);
        }
    }

    public void a(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.dQN);
        if (i == 1) {
            this.dQI.setAlpha(0.7f);
            this.dQI.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.dQJ.setAlpha(0.7f);
            this.dQJ.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.dQK.setAlpha(0.7f);
            this.dQK.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.dQL.setAlpha(0.7f);
            this.dQL.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.sdk_prc_current_level_bg));
        }
    }
}
