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
    private TextView eMa;
    private TextView eMb;
    private TextView eMc;
    private View eMd;
    private LinearLayout eMe;
    private LinearLayout eMf;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        initView(bgL());
    }

    public View bgL() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void initView(View view) {
        this.eMf = (LinearLayout) view.findViewById(a.g.ala_person_center_current_exp_panel);
        this.eMa = (TextView) view.findViewById(a.g.ala_person_center_current_exp_txt);
        this.eMb = (TextView) view.findViewById(a.g.ala_person_center_current_level);
        this.eMc = (TextView) view.findViewById(a.g.ala_person_center_next_level);
        this.eMe = (LinearLayout) view.findViewById(a.g.ala_person_center_next_level_bg);
        this.eMd = view.findViewById(a.g.ala_person_center_current_level_bg);
    }

    public void i(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.eLm[i - 1];
        int i2 = i + 1;
        this.eMa.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.eMb.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.eMc.setText("");
        } else {
            this.eMc.setText(this.mContext.getResources().getString(a.i.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.eMd.getLayoutParams();
            layoutParams.width = (int) ((this.eMe.getLayoutParams().width * j) / j2);
            this.eMd.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.eMf);
        if (i == 1) {
            this.eMa.setAlpha(0.7f);
            this.eMa.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.eMb.setAlpha(0.7f);
            this.eMb.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.eMc.setAlpha(0.7f);
            this.eMc.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.eMd.setAlpha(0.7f);
            this.eMd.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.sdk_prc_current_level_bg));
        }
    }
}
