package com.baidu.tieba.ala.live.personcenter.exp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.q.a;
/* loaded from: classes2.dex */
public class c {
    private TextView eGm;
    private TextView eGn;
    private TextView eGo;
    private View eGp;
    private LinearLayout eGq;
    private LinearLayout eGr;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        initView(bdY());
    }

    public View bdY() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void initView(View view) {
        this.eGr = (LinearLayout) view.findViewById(a.g.ala_person_center_current_exp_panel);
        this.eGm = (TextView) view.findViewById(a.g.ala_person_center_current_exp_txt);
        this.eGn = (TextView) view.findViewById(a.g.ala_person_center_current_level);
        this.eGo = (TextView) view.findViewById(a.g.ala_person_center_next_level);
        this.eGq = (LinearLayout) view.findViewById(a.g.ala_person_center_next_level_bg);
        this.eGp = view.findViewById(a.g.ala_person_center_current_level_bg);
    }

    public void i(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.eFy[i - 1];
        int i2 = i + 1;
        this.eGm.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.eGn.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.eGo.setText("");
        } else {
            this.eGo.setText(this.mContext.getResources().getString(a.i.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.eGp.getLayoutParams();
            layoutParams.width = (int) ((this.eGq.getLayoutParams().width * j) / j2);
            this.eGp.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.eGr);
        if (i == 1) {
            this.eGm.setAlpha(0.7f);
            this.eGm.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.eGn.setAlpha(0.7f);
            this.eGn.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.eGo.setAlpha(0.7f);
            this.eGo.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.eGp.setAlpha(0.7f);
            this.eGp.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.sdk_prc_current_level_bg));
        }
    }
}
