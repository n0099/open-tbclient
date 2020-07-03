package com.baidu.tieba.ala.live.personcenter.exp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes3.dex */
public class c {
    private TextView fPL;
    private TextView fPM;
    private TextView fPN;
    private View fPO;
    private LinearLayout fPP;
    private LinearLayout fPQ;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        ag(byQ());
    }

    public View byQ() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void ag(View view) {
        this.fPQ = (LinearLayout) view.findViewById(a.g.ala_person_center_current_exp_panel);
        this.fPL = (TextView) view.findViewById(a.g.ala_person_center_current_exp_txt);
        this.fPM = (TextView) view.findViewById(a.g.ala_person_center_current_level);
        this.fPN = (TextView) view.findViewById(a.g.ala_person_center_next_level);
        this.fPP = (LinearLayout) view.findViewById(a.g.ala_person_center_next_level_bg);
        this.fPO = view.findViewById(a.g.ala_person_center_current_level_bg);
    }

    public void i(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.fOY[i - 1];
        int i2 = i + 1;
        this.fPL.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.fPM.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.fPN.setText("");
        } else {
            this.fPN.setText(this.mContext.getResources().getString(a.i.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.fPO.getLayoutParams();
            layoutParams.width = (int) ((this.fPP.getLayoutParams().width * j) / j2);
            this.fPO.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.fPQ);
        if (i == 1) {
            this.fPL.setAlpha(0.7f);
            this.fPL.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.fPM.setAlpha(0.7f);
            this.fPM.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.fPN.setAlpha(0.7f);
            this.fPN.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.fPO.setAlpha(0.7f);
            this.fPO.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.sdk_prc_current_level_bg));
        }
    }
}
