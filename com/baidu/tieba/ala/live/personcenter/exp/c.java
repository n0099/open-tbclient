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
    private TextView gZf;
    private TextView gZg;
    private TextView gZh;
    private View gZi;
    private LinearLayout gZj;
    private LinearLayout gZk;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        an(bYz());
    }

    public View bYz() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void an(View view) {
        this.gZk = (LinearLayout) view.findViewById(a.f.ala_person_center_current_exp_panel);
        this.gZf = (TextView) view.findViewById(a.f.ala_person_center_current_exp_txt);
        this.gZg = (TextView) view.findViewById(a.f.ala_person_center_current_level);
        this.gZh = (TextView) view.findViewById(a.f.ala_person_center_next_level);
        this.gZj = (LinearLayout) view.findViewById(a.f.ala_person_center_next_level_bg);
        this.gZi = view.findViewById(a.f.ala_person_center_current_level_bg);
    }

    public void w(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.gYs[i - 1];
        int i2 = i + 1;
        this.gZf.setText(this.mContext.getResources().getString(a.h.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.gZg.setText(this.mContext.getResources().getString(a.h.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.gZh.setText("");
        } else {
            this.gZh.setText(this.mContext.getResources().getString(a.h.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.gZi.getLayoutParams();
            layoutParams.width = (int) ((this.gZj.getLayoutParams().width * j) / j2);
            this.gZi.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.gZk);
        if (i == 1) {
            this.gZf.setAlpha(0.7f);
            this.gZf.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.gZg.setAlpha(0.7f);
            this.gZg.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.gZh.setAlpha(0.7f);
            this.gZh.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.gZi.setAlpha(0.7f);
            this.gZi.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.e.sdk_prc_current_level_bg));
        }
    }
}
