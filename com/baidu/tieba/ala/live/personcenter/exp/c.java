package com.baidu.tieba.ala.live.personcenter.exp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class c {
    private TextView gPS;
    private TextView gPT;
    private TextView gPU;
    private View gPV;
    private LinearLayout gPW;
    private LinearLayout gPX;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        al(bUQ());
    }

    public View bUQ() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void al(View view) {
        this.gPX = (LinearLayout) view.findViewById(a.f.ala_person_center_current_exp_panel);
        this.gPS = (TextView) view.findViewById(a.f.ala_person_center_current_exp_txt);
        this.gPT = (TextView) view.findViewById(a.f.ala_person_center_current_level);
        this.gPU = (TextView) view.findViewById(a.f.ala_person_center_next_level);
        this.gPW = (LinearLayout) view.findViewById(a.f.ala_person_center_next_level_bg);
        this.gPV = view.findViewById(a.f.ala_person_center_current_level_bg);
    }

    public void u(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.gPf[i - 1];
        int i2 = i + 1;
        this.gPS.setText(this.mContext.getResources().getString(a.h.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.gPT.setText(this.mContext.getResources().getString(a.h.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.gPU.setText("");
        } else {
            this.gPU.setText(this.mContext.getResources().getString(a.h.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.gPV.getLayoutParams();
            layoutParams.width = (int) ((this.gPW.getLayoutParams().width * j) / j2);
            this.gPV.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.gPX);
        if (i == 1) {
            this.gPS.setAlpha(0.7f);
            this.gPS.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.gPT.setAlpha(0.7f);
            this.gPT.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.gPU.setAlpha(0.7f);
            this.gPU.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.gPV.setAlpha(0.7f);
            this.gPV.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.e.sdk_prc_current_level_bg));
        }
    }
}
