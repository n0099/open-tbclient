package com.baidu.tieba.ala.live.personcenter.exp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class c {
    private TextView ghh;
    private TextView ghi;
    private TextView ghj;
    private View ghk;
    private LinearLayout ghl;
    private LinearLayout ghm;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        ak(bLA());
    }

    public View bLA() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void ak(View view) {
        this.ghm = (LinearLayout) view.findViewById(a.g.ala_person_center_current_exp_panel);
        this.ghh = (TextView) view.findViewById(a.g.ala_person_center_current_exp_txt);
        this.ghi = (TextView) view.findViewById(a.g.ala_person_center_current_level);
        this.ghj = (TextView) view.findViewById(a.g.ala_person_center_next_level);
        this.ghl = (LinearLayout) view.findViewById(a.g.ala_person_center_next_level_bg);
        this.ghk = view.findViewById(a.g.ala_person_center_current_level_bg);
    }

    public void j(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.ggu[i - 1];
        int i2 = i + 1;
        this.ghh.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.ghi.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.ghj.setText("");
        } else {
            this.ghj.setText(this.mContext.getResources().getString(a.i.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.ghk.getLayoutParams();
            layoutParams.width = (int) ((this.ghl.getLayoutParams().width * j) / j2);
            this.ghk.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.ghm);
        if (i == 1) {
            this.ghh.setAlpha(0.7f);
            this.ghh.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.ghi.setAlpha(0.7f);
            this.ghi.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.ghj.setAlpha(0.7f);
            this.ghj.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.ghk.setAlpha(0.7f);
            this.ghk.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.sdk_prc_current_level_bg));
        }
    }
}
