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
    private TextView eLq;
    private TextView eLr;
    private TextView eLs;
    private View eLt;
    private LinearLayout eLu;
    private LinearLayout eLv;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        initView(bgD());
    }

    public View bgD() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void initView(View view) {
        this.eLv = (LinearLayout) view.findViewById(a.g.ala_person_center_current_exp_panel);
        this.eLq = (TextView) view.findViewById(a.g.ala_person_center_current_exp_txt);
        this.eLr = (TextView) view.findViewById(a.g.ala_person_center_current_level);
        this.eLs = (TextView) view.findViewById(a.g.ala_person_center_next_level);
        this.eLu = (LinearLayout) view.findViewById(a.g.ala_person_center_next_level_bg);
        this.eLt = view.findViewById(a.g.ala_person_center_current_level_bg);
    }

    public void i(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.eKC[i - 1];
        int i2 = i + 1;
        this.eLq.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.eLr.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.eLs.setText("");
        } else {
            this.eLs.setText(this.mContext.getResources().getString(a.i.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.eLt.getLayoutParams();
            layoutParams.width = (int) ((this.eLu.getLayoutParams().width * j) / j2);
            this.eLt.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.eLv);
        if (i == 1) {
            this.eLq.setAlpha(0.7f);
            this.eLq.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.eLr.setAlpha(0.7f);
            this.eLr.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.eLs.setAlpha(0.7f);
            this.eLs.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.eLt.setAlpha(0.7f);
            this.eLt.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.sdk_prc_current_level_bg));
        }
    }
}
