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
    private TextView hgp;
    private TextView hgq;
    private TextView hgr;
    private View hgs;
    private LinearLayout hgt;
    private LinearLayout hgu;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        ap(bXo());
    }

    public View bXo() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void ap(View view) {
        this.hgu = (LinearLayout) view.findViewById(a.f.ala_person_center_current_exp_panel);
        this.hgp = (TextView) view.findViewById(a.f.ala_person_center_current_exp_txt);
        this.hgq = (TextView) view.findViewById(a.f.ala_person_center_current_level);
        this.hgr = (TextView) view.findViewById(a.f.ala_person_center_next_level);
        this.hgt = (LinearLayout) view.findViewById(a.f.ala_person_center_next_level_bg);
        this.hgs = view.findViewById(a.f.ala_person_center_current_level_bg);
    }

    public void y(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.hfC[i - 1];
        int i2 = i + 1;
        this.hgp.setText(this.mContext.getResources().getString(a.h.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.hgq.setText(this.mContext.getResources().getString(a.h.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.hgr.setText("");
        } else {
            this.hgr.setText(this.mContext.getResources().getString(a.h.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.hgs.getLayoutParams();
            layoutParams.width = (int) ((this.hgt.getLayoutParams().width * j) / j2);
            this.hgs.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.hgu);
        if (i == 1) {
            this.hgp.setAlpha(0.7f);
            this.hgp.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.hgq.setAlpha(0.7f);
            this.hgq.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.hgr.setAlpha(0.7f);
            this.hgr.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.hgs.setAlpha(0.7f);
            this.hgs.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.e.sdk_prc_current_level_bg));
        }
    }
}
