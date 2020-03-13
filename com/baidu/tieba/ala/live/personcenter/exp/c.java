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
    private TextView eLE;
    private TextView eLF;
    private TextView eLG;
    private View eLH;
    private LinearLayout eLI;
    private LinearLayout eLJ;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        initView(bgG());
    }

    public View bgG() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void initView(View view) {
        this.eLJ = (LinearLayout) view.findViewById(a.g.ala_person_center_current_exp_panel);
        this.eLE = (TextView) view.findViewById(a.g.ala_person_center_current_exp_txt);
        this.eLF = (TextView) view.findViewById(a.g.ala_person_center_current_level);
        this.eLG = (TextView) view.findViewById(a.g.ala_person_center_next_level);
        this.eLI = (LinearLayout) view.findViewById(a.g.ala_person_center_next_level_bg);
        this.eLH = view.findViewById(a.g.ala_person_center_current_level_bg);
    }

    public void i(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.eKQ[i - 1];
        int i2 = i + 1;
        this.eLE.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.eLF.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.eLG.setText("");
        } else {
            this.eLG.setText(this.mContext.getResources().getString(a.i.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.eLH.getLayoutParams();
            layoutParams.width = (int) ((this.eLI.getLayoutParams().width * j) / j2);
            this.eLH.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.eLJ);
        if (i == 1) {
            this.eLE.setAlpha(0.7f);
            this.eLE.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.eLF.setAlpha(0.7f);
            this.eLF.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.eLG.setAlpha(0.7f);
            this.eLG.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.eLH.setAlpha(0.7f);
            this.eLH.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.sdk_prc_current_level_bg));
        }
    }
}
