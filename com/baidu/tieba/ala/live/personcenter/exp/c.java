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
    private TextView hkT;
    private TextView hkU;
    private TextView hkV;
    private View hkW;
    private LinearLayout hkX;
    private LinearLayout hkY;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        am(bYv());
    }

    public View bYv() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public final void am(View view) {
        this.hkY = (LinearLayout) view.findViewById(a.f.ala_person_center_current_exp_panel);
        this.hkT = (TextView) view.findViewById(a.f.ala_person_center_current_exp_txt);
        this.hkU = (TextView) view.findViewById(a.f.ala_person_center_current_level);
        this.hkV = (TextView) view.findViewById(a.f.ala_person_center_next_level);
        this.hkX = (LinearLayout) view.findViewById(a.f.ala_person_center_next_level_bg);
        this.hkW = view.findViewById(a.f.ala_person_center_current_level_bg);
    }

    public void w(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.hkg[i - 1];
        int i2 = i + 1;
        this.hkT.setText(this.mContext.getResources().getString(a.h.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.hkU.setText(this.mContext.getResources().getString(a.h.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.hkV.setText("");
        } else {
            this.hkV.setText(this.mContext.getResources().getString(a.h.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.hkW.getLayoutParams();
            layoutParams.width = (int) ((this.hkX.getLayoutParams().width * j) / j2);
            this.hkW.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.hkY);
        if (i == 1) {
            this.hkT.setAlpha(0.7f);
            this.hkT.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.hkU.setAlpha(0.7f);
            this.hkU.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.hkV.setAlpha(0.7f);
            this.hkV.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.hkW.setAlpha(0.7f);
            this.hkW.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.e.sdk_prc_current_level_bg));
        }
    }
}
