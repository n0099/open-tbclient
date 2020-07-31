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
    private TextView fVe;
    private TextView fVf;
    private TextView fVg;
    private View fVh;
    private LinearLayout fVi;
    private LinearLayout fVj;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        aj(bCf());
    }

    public View bCf() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void aj(View view) {
        this.fVj = (LinearLayout) view.findViewById(a.g.ala_person_center_current_exp_panel);
        this.fVe = (TextView) view.findViewById(a.g.ala_person_center_current_exp_txt);
        this.fVf = (TextView) view.findViewById(a.g.ala_person_center_current_level);
        this.fVg = (TextView) view.findViewById(a.g.ala_person_center_next_level);
        this.fVi = (LinearLayout) view.findViewById(a.g.ala_person_center_next_level_bg);
        this.fVh = view.findViewById(a.g.ala_person_center_current_level_bg);
    }

    public void j(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.fUr[i - 1];
        int i2 = i + 1;
        this.fVe.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.fVf.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.fVg.setText("");
        } else {
            this.fVg.setText(this.mContext.getResources().getString(a.i.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.fVh.getLayoutParams();
            layoutParams.width = (int) ((this.fVi.getLayoutParams().width * j) / j2);
            this.fVh.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.fVj);
        if (i == 1) {
            this.fVe.setAlpha(0.7f);
            this.fVe.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.fVf.setAlpha(0.7f);
            this.fVf.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.fVg.setAlpha(0.7f);
            this.fVg.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.fVh.setAlpha(0.7f);
            this.fVh.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.sdk_prc_current_level_bg));
        }
    }
}
