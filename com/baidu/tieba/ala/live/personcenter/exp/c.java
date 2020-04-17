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
    private TextView fqs;
    private TextView fqt;
    private TextView fqu;
    private View fqv;
    private LinearLayout fqw;
    private LinearLayout fqx;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        ag(bqc());
    }

    public View bqc() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void ag(View view) {
        this.fqx = (LinearLayout) view.findViewById(a.g.ala_person_center_current_exp_panel);
        this.fqs = (TextView) view.findViewById(a.g.ala_person_center_current_exp_txt);
        this.fqt = (TextView) view.findViewById(a.g.ala_person_center_current_level);
        this.fqu = (TextView) view.findViewById(a.g.ala_person_center_next_level);
        this.fqw = (LinearLayout) view.findViewById(a.g.ala_person_center_next_level_bg);
        this.fqv = view.findViewById(a.g.ala_person_center_current_level_bg);
    }

    public void i(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.fpF[i - 1];
        int i2 = i + 1;
        this.fqs.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.fqt.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.fqu.setText("");
        } else {
            this.fqu.setText(this.mContext.getResources().getString(a.i.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.fqv.getLayoutParams();
            layoutParams.width = (int) ((this.fqw.getLayoutParams().width * j) / j2);
            this.fqv.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.fqx);
        if (i == 1) {
            this.fqs.setAlpha(0.7f);
            this.fqs.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.fqt.setAlpha(0.7f);
            this.fqt.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.fqu.setAlpha(0.7f);
            this.fqu.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.fqv.setAlpha(0.7f);
            this.fqv.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.sdk_prc_current_level_bg));
        }
    }
}
