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
    private TextView gQl;
    private TextView gQm;
    private TextView gQn;
    private View gQo;
    private LinearLayout gQp;
    private LinearLayout gQq;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        al(bVx());
    }

    public View bVx() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void al(View view) {
        this.gQq = (LinearLayout) view.findViewById(a.f.ala_person_center_current_exp_panel);
        this.gQl = (TextView) view.findViewById(a.f.ala_person_center_current_exp_txt);
        this.gQm = (TextView) view.findViewById(a.f.ala_person_center_current_level);
        this.gQn = (TextView) view.findViewById(a.f.ala_person_center_next_level);
        this.gQp = (LinearLayout) view.findViewById(a.f.ala_person_center_next_level_bg);
        this.gQo = view.findViewById(a.f.ala_person_center_current_level_bg);
    }

    public void u(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.gPy[i - 1];
        int i2 = i + 1;
        this.gQl.setText(this.mContext.getResources().getString(a.h.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.gQm.setText(this.mContext.getResources().getString(a.h.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.gQn.setText("");
        } else {
            this.gQn.setText(this.mContext.getResources().getString(a.h.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.gQo.getLayoutParams();
            layoutParams.width = (int) ((this.gQp.getLayoutParams().width * j) / j2);
            this.gQo.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.gQq);
        if (i == 1) {
            this.gQl.setAlpha(0.7f);
            this.gQl.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.gQm.setAlpha(0.7f);
            this.gQm.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.gQn.setAlpha(0.7f);
            this.gQn.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
            this.gQo.setAlpha(0.7f);
            this.gQo.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.e.sdk_prc_current_level_bg));
        }
    }
}
