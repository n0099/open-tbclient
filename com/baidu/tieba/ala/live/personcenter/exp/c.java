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
    private TextView hkW;
    private TextView hkX;
    private TextView hkY;
    private View hkZ;
    private LinearLayout hla;
    private LinearLayout hlb;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        ap(cbg());
    }

    public View cbg() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void ap(View view) {
        this.hlb = (LinearLayout) view.findViewById(a.f.ala_person_center_current_exp_panel);
        this.hkW = (TextView) view.findViewById(a.f.ala_person_center_current_exp_txt);
        this.hkX = (TextView) view.findViewById(a.f.ala_person_center_current_level);
        this.hkY = (TextView) view.findViewById(a.f.ala_person_center_next_level);
        this.hla = (LinearLayout) view.findViewById(a.f.ala_person_center_next_level_bg);
        this.hkZ = view.findViewById(a.f.ala_person_center_current_level_bg);
    }

    public void y(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.hkj[i - 1];
        int i2 = i + 1;
        this.hkW.setText(this.mContext.getResources().getString(a.h.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.hkX.setText(this.mContext.getResources().getString(a.h.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.hkY.setText("");
        } else {
            this.hkY.setText(this.mContext.getResources().getString(a.h.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.hkZ.getLayoutParams();
            layoutParams.width = (int) ((this.hla.getLayoutParams().width * j) / j2);
            this.hkZ.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.hlb);
        if (i == 1) {
            this.hkW.setAlpha(0.7f);
            this.hkW.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.hkX.setAlpha(0.7f);
            this.hkX.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.hkY.setAlpha(0.7f);
            this.hkY.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.hkZ.setAlpha(0.7f);
            this.hkZ.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.e.sdk_prc_current_level_bg));
        }
    }
}
