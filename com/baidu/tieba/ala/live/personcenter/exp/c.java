package com.baidu.tieba.ala.live.personcenter.exp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class c {
    private TextView fEC;
    private TextView fED;
    private TextView fEE;
    private View fEF;
    private LinearLayout fEG;
    private LinearLayout fEH;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        ag(bvV());
    }

    public View bvV() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void ag(View view) {
        this.fEH = (LinearLayout) view.findViewById(a.g.ala_person_center_current_exp_panel);
        this.fEC = (TextView) view.findViewById(a.g.ala_person_center_current_exp_txt);
        this.fED = (TextView) view.findViewById(a.g.ala_person_center_current_level);
        this.fEE = (TextView) view.findViewById(a.g.ala_person_center_next_level);
        this.fEG = (LinearLayout) view.findViewById(a.g.ala_person_center_next_level_bg);
        this.fEF = view.findViewById(a.g.ala_person_center_current_level_bg);
    }

    public void i(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.fDP[i - 1];
        int i2 = i + 1;
        this.fEC.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.fED.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.fEE.setText("");
        } else {
            this.fEE.setText(this.mContext.getResources().getString(a.i.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.fEF.getLayoutParams();
            layoutParams.width = (int) ((this.fEG.getLayoutParams().width * j) / j2);
            this.fEF.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.fEH);
        if (i == 1) {
            this.fEC.setAlpha(0.7f);
            this.fEC.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.fED.setAlpha(0.7f);
            this.fED.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.fEE.setAlpha(0.7f);
            this.fEE.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.fEF.setAlpha(0.7f);
            this.fEF.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.sdk_prc_current_level_bg));
        }
    }
}
