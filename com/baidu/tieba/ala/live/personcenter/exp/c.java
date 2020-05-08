package com.baidu.tieba.ala.live.personcenter.exp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class c {
    private View fqA;
    private LinearLayout fqB;
    private LinearLayout fqC;
    private TextView fqx;
    private TextView fqy;
    private TextView fqz;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        ag(bqa());
    }

    public View bqa() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void ag(View view) {
        this.fqC = (LinearLayout) view.findViewById(a.g.ala_person_center_current_exp_panel);
        this.fqx = (TextView) view.findViewById(a.g.ala_person_center_current_exp_txt);
        this.fqy = (TextView) view.findViewById(a.g.ala_person_center_current_level);
        this.fqz = (TextView) view.findViewById(a.g.ala_person_center_next_level);
        this.fqB = (LinearLayout) view.findViewById(a.g.ala_person_center_next_level_bg);
        this.fqA = view.findViewById(a.g.ala_person_center_current_level_bg);
    }

    public void i(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.fpK[i - 1];
        int i2 = i + 1;
        this.fqx.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.fqy.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.fqz.setText("");
        } else {
            this.fqz.setText(this.mContext.getResources().getString(a.i.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.fqA.getLayoutParams();
            layoutParams.width = (int) ((this.fqB.getLayoutParams().width * j) / j2);
            this.fqA.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.fqC);
        if (i == 1) {
            this.fqx.setAlpha(0.7f);
            this.fqx.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.fqy.setAlpha(0.7f);
            this.fqy.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.fqz.setAlpha(0.7f);
            this.fqz.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.fqA.setAlpha(0.7f);
            this.fqA.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.sdk_prc_current_level_bg));
        }
    }
}
