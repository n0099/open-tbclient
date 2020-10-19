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
    private TextView gyL;
    private TextView gyM;
    private TextView gyN;
    private View gyO;
    private LinearLayout gyP;
    private LinearLayout gyQ;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        an(bQb());
    }

    public View bQb() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void an(View view) {
        this.gyQ = (LinearLayout) view.findViewById(a.g.ala_person_center_current_exp_panel);
        this.gyL = (TextView) view.findViewById(a.g.ala_person_center_current_exp_txt);
        this.gyM = (TextView) view.findViewById(a.g.ala_person_center_current_level);
        this.gyN = (TextView) view.findViewById(a.g.ala_person_center_next_level);
        this.gyP = (LinearLayout) view.findViewById(a.g.ala_person_center_next_level_bg);
        this.gyO = view.findViewById(a.g.ala_person_center_current_level_bg);
    }

    public void q(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.gxY[i - 1];
        int i2 = i + 1;
        this.gyL.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.gyM.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.gyN.setText("");
        } else {
            this.gyN.setText(this.mContext.getResources().getString(a.i.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.gyO.getLayoutParams();
            layoutParams.width = (int) ((this.gyP.getLayoutParams().width * j) / j2);
            this.gyO.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.gyQ);
        if (i == 1) {
            this.gyL.setAlpha(0.7f);
            this.gyL.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.gyM.setAlpha(0.7f);
            this.gyM.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.gyN.setAlpha(0.7f);
            this.gyN.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.gyO.setAlpha(0.7f);
            this.gyO.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.sdk_prc_current_level_bg));
        }
    }
}
