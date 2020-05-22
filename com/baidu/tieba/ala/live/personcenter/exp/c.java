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
    private TextView fEr;
    private TextView fEs;
    private TextView fEt;
    private View fEu;
    private LinearLayout fEv;
    private LinearLayout fEw;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        ag(bvT());
    }

    public View bvT() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void ag(View view) {
        this.fEw = (LinearLayout) view.findViewById(a.g.ala_person_center_current_exp_panel);
        this.fEr = (TextView) view.findViewById(a.g.ala_person_center_current_exp_txt);
        this.fEs = (TextView) view.findViewById(a.g.ala_person_center_current_level);
        this.fEt = (TextView) view.findViewById(a.g.ala_person_center_next_level);
        this.fEv = (LinearLayout) view.findViewById(a.g.ala_person_center_next_level_bg);
        this.fEu = view.findViewById(a.g.ala_person_center_current_level_bg);
    }

    public void i(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.fDE[i - 1];
        int i2 = i + 1;
        this.fEr.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.fEs.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.fEt.setText("");
        } else {
            this.fEt.setText(this.mContext.getResources().getString(a.i.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.fEu.getLayoutParams();
            layoutParams.width = (int) ((this.fEv.getLayoutParams().width * j) / j2);
            this.fEu.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.fEw);
        if (i == 1) {
            this.fEr.setAlpha(0.7f);
            this.fEr.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.fEs.setAlpha(0.7f);
            this.fEs.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.fEt.setAlpha(0.7f);
            this.fEt.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.fEu.setAlpha(0.7f);
            this.fEu.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.sdk_prc_current_level_bg));
        }
    }
}
