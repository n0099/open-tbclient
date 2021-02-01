package com.baidu.tieba.ala.live.personcenter.exp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class c {
    private TextView hkF;
    private TextView hkG;
    private TextView hkH;
    private View hkI;
    private LinearLayout hkJ;
    private LinearLayout hkK;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        am(bYo());
    }

    public View bYo() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public final void am(View view) {
        this.hkK = (LinearLayout) view.findViewById(a.f.ala_person_center_current_exp_panel);
        this.hkF = (TextView) view.findViewById(a.f.ala_person_center_current_exp_txt);
        this.hkG = (TextView) view.findViewById(a.f.ala_person_center_current_level);
        this.hkH = (TextView) view.findViewById(a.f.ala_person_center_next_level);
        this.hkJ = (LinearLayout) view.findViewById(a.f.ala_person_center_next_level_bg);
        this.hkI = view.findViewById(a.f.ala_person_center_current_level_bg);
    }

    public void w(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.hjS[i - 1];
        int i2 = i + 1;
        this.hkF.setText(this.mContext.getResources().getString(a.h.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.hkG.setText(this.mContext.getResources().getString(a.h.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.hkH.setText("");
        } else {
            this.hkH.setText(this.mContext.getResources().getString(a.h.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.hkI.getLayoutParams();
            layoutParams.width = (int) ((this.hkJ.getLayoutParams().width * j) / j2);
            this.hkI.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.hkK);
        if (i == 1) {
            this.hkF.setAlpha(0.7f);
            this.hkF.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.hkG.setAlpha(0.7f);
            this.hkG.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.hkH.setAlpha(0.7f);
            this.hkH.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.hkI.setAlpha(0.7f);
            this.hkI.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.e.sdk_prc_current_level_bg));
        }
    }
}
