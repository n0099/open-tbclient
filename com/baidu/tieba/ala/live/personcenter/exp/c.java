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
    private TextView eLr;
    private TextView eLs;
    private TextView eLt;
    private View eLu;
    private LinearLayout eLv;
    private LinearLayout eLw;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        initView(bgF());
    }

    public View bgF() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void initView(View view) {
        this.eLw = (LinearLayout) view.findViewById(a.g.ala_person_center_current_exp_panel);
        this.eLr = (TextView) view.findViewById(a.g.ala_person_center_current_exp_txt);
        this.eLs = (TextView) view.findViewById(a.g.ala_person_center_current_level);
        this.eLt = (TextView) view.findViewById(a.g.ala_person_center_next_level);
        this.eLv = (LinearLayout) view.findViewById(a.g.ala_person_center_next_level_bg);
        this.eLu = view.findViewById(a.g.ala_person_center_current_level_bg);
    }

    public void i(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.eKD[i - 1];
        int i2 = i + 1;
        this.eLr.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.eLs.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.eLt.setText("");
        } else {
            this.eLt.setText(this.mContext.getResources().getString(a.i.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.eLu.getLayoutParams();
            layoutParams.width = (int) ((this.eLv.getLayoutParams().width * j) / j2);
            this.eLu.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.eLw);
        if (i == 1) {
            this.eLr.setAlpha(0.7f);
            this.eLr.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.eLs.setAlpha(0.7f);
            this.eLs.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.eLt.setAlpha(0.7f);
            this.eLt.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.eLu.setAlpha(0.7f);
            this.eLu.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.sdk_prc_current_level_bg));
        }
    }
}
