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
    private TextView ghd;
    private TextView ghe;
    private TextView ghf;
    private View ghg;
    private LinearLayout ghh;
    private LinearLayout ghi;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        ak(bLz());
    }

    public View bLz() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void ak(View view) {
        this.ghi = (LinearLayout) view.findViewById(a.g.ala_person_center_current_exp_panel);
        this.ghd = (TextView) view.findViewById(a.g.ala_person_center_current_exp_txt);
        this.ghe = (TextView) view.findViewById(a.g.ala_person_center_current_level);
        this.ghf = (TextView) view.findViewById(a.g.ala_person_center_next_level);
        this.ghh = (LinearLayout) view.findViewById(a.g.ala_person_center_next_level_bg);
        this.ghg = view.findViewById(a.g.ala_person_center_current_level_bg);
    }

    public void j(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.ggq[i - 1];
        int i2 = i + 1;
        this.ghd.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.ghe.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.ghf.setText("");
        } else {
            this.ghf.setText(this.mContext.getResources().getString(a.i.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.ghg.getLayoutParams();
            layoutParams.width = (int) ((this.ghh.getLayoutParams().width * j) / j2);
            this.ghg.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.ghi);
        if (i == 1) {
            this.ghd.setAlpha(0.7f);
            this.ghd.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.ghe.setAlpha(0.7f);
            this.ghe.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.ghf.setAlpha(0.7f);
            this.ghf.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.ghg.setAlpha(0.7f);
            this.ghg.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.sdk_prc_current_level_bg));
        }
    }
}
