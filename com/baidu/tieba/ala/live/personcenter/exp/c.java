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
    private TextView gZh;
    private TextView gZi;
    private TextView gZj;
    private View gZk;
    private LinearLayout gZl;
    private LinearLayout gZm;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        an(bYA());
    }

    public View bYA() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void an(View view) {
        this.gZm = (LinearLayout) view.findViewById(a.f.ala_person_center_current_exp_panel);
        this.gZh = (TextView) view.findViewById(a.f.ala_person_center_current_exp_txt);
        this.gZi = (TextView) view.findViewById(a.f.ala_person_center_current_level);
        this.gZj = (TextView) view.findViewById(a.f.ala_person_center_next_level);
        this.gZl = (LinearLayout) view.findViewById(a.f.ala_person_center_next_level_bg);
        this.gZk = view.findViewById(a.f.ala_person_center_current_level_bg);
    }

    public void w(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.gYu[i - 1];
        int i2 = i + 1;
        this.gZh.setText(this.mContext.getResources().getString(a.h.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.gZi.setText(this.mContext.getResources().getString(a.h.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.gZj.setText("");
        } else {
            this.gZj.setText(this.mContext.getResources().getString(a.h.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.gZk.getLayoutParams();
            layoutParams.width = (int) ((this.gZl.getLayoutParams().width * j) / j2);
            this.gZk.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.gZm);
        if (i == 1) {
            this.gZh.setAlpha(0.7f);
            this.gZh.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.gZi.setAlpha(0.7f);
            this.gZi.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.gZj.setAlpha(0.7f);
            this.gZj.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.gZk.setAlpha(0.7f);
            this.gZk.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.e.sdk_prc_current_level_bg));
        }
    }
}
