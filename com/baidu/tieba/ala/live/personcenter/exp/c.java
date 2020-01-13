package com.baidu.tieba.ala.live.personcenter.exp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class c {
    private LinearLayout eHA;
    private LinearLayout eHB;
    private TextView eHw;
    private TextView eHx;
    private TextView eHy;
    private View eHz;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        initView(bet());
    }

    public View bet() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void initView(View view) {
        this.eHB = (LinearLayout) view.findViewById(a.g.ala_person_center_current_exp_panel);
        this.eHw = (TextView) view.findViewById(a.g.ala_person_center_current_exp_txt);
        this.eHx = (TextView) view.findViewById(a.g.ala_person_center_current_level);
        this.eHy = (TextView) view.findViewById(a.g.ala_person_center_next_level);
        this.eHA = (LinearLayout) view.findViewById(a.g.ala_person_center_next_level_bg);
        this.eHz = view.findViewById(a.g.ala_person_center_current_level_bg);
    }

    public void i(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.eGI[i - 1];
        int i2 = i + 1;
        this.eHw.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.eHx.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.eHy.setText("");
        } else {
            this.eHy.setText(this.mContext.getResources().getString(a.i.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.eHz.getLayoutParams();
            layoutParams.width = (int) ((this.eHA.getLayoutParams().width * j) / j2);
            this.eHz.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.eHB);
        if (i == 1) {
            this.eHw.setAlpha(0.7f);
            this.eHw.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.eHx.setAlpha(0.7f);
            this.eHx.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.eHy.setAlpha(0.7f);
            this.eHy.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.eHz.setAlpha(0.7f);
            this.eHz.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.sdk_prc_current_level_bg));
        }
    }
}
