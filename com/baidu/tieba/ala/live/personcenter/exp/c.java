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
    private TextView gKA;
    private TextView gKB;
    private View gKC;
    private LinearLayout gKD;
    private LinearLayout gKE;
    private TextView gKz;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        ah(bSY());
    }

    public View bSY() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void ah(View view) {
        this.gKE = (LinearLayout) view.findViewById(a.g.ala_person_center_current_exp_panel);
        this.gKz = (TextView) view.findViewById(a.g.ala_person_center_current_exp_txt);
        this.gKA = (TextView) view.findViewById(a.g.ala_person_center_current_level);
        this.gKB = (TextView) view.findViewById(a.g.ala_person_center_next_level);
        this.gKD = (LinearLayout) view.findViewById(a.g.ala_person_center_next_level_bg);
        this.gKC = view.findViewById(a.g.ala_person_center_current_level_bg);
    }

    public void q(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.gJM[i - 1];
        int i2 = i + 1;
        this.gKz.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.gKA.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.gKB.setText("");
        } else {
            this.gKB.setText(this.mContext.getResources().getString(a.i.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.gKC.getLayoutParams();
            layoutParams.width = (int) ((this.gKD.getLayoutParams().width * j) / j2);
            this.gKC.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.gKE);
        if (i == 1) {
            this.gKz.setAlpha(0.7f);
            this.gKz.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.gKA.setAlpha(0.7f);
            this.gKA.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.gKB.setAlpha(0.7f);
            this.gKB.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.gKC.setAlpha(0.7f);
            this.gKC.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.sdk_prc_current_level_bg));
        }
    }
}
