package com.baidu.tieba.ala.live.personcenter.exp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class c {
    private TextView hmC;
    private TextView hmD;
    private TextView hmE;
    private View hmF;
    private LinearLayout hmG;
    private LinearLayout hmH;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        am(bYB());
    }

    public View bYB() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public final void am(View view) {
        this.hmH = (LinearLayout) view.findViewById(a.f.ala_person_center_current_exp_panel);
        this.hmC = (TextView) view.findViewById(a.f.ala_person_center_current_exp_txt);
        this.hmD = (TextView) view.findViewById(a.f.ala_person_center_current_level);
        this.hmE = (TextView) view.findViewById(a.f.ala_person_center_next_level);
        this.hmG = (LinearLayout) view.findViewById(a.f.ala_person_center_next_level_bg);
        this.hmF = view.findViewById(a.f.ala_person_center_current_level_bg);
    }

    public void w(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.hlP[i - 1];
        int i2 = i + 1;
        this.hmC.setText(this.mContext.getResources().getString(a.h.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.hmD.setText(this.mContext.getResources().getString(a.h.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.hmE.setText("");
        } else {
            this.hmE.setText(this.mContext.getResources().getString(a.h.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.hmF.getLayoutParams();
            layoutParams.width = (int) ((this.hmG.getLayoutParams().width * j) / j2);
            this.hmF.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.hmH);
        if (i == 1) {
            this.hmC.setAlpha(0.7f);
            this.hmC.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.hmD.setAlpha(0.7f);
            this.hmD.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.hmE.setAlpha(0.7f);
            this.hmE.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.hmF.setAlpha(0.7f);
            this.hmF.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.e.sdk_prc_current_level_bg));
        }
    }
}
