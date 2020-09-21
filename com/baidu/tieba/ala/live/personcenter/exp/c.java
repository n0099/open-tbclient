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
    private TextView gks;
    private TextView gkt;
    private TextView gku;
    private View gkv;
    private LinearLayout gkw;
    private LinearLayout gkx;
    protected Context mContext;
    private View mRootView;

    public c(Context context) {
        this.mContext = context;
        am(bMK());
    }

    public View bMK() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_top_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void am(View view) {
        this.gkx = (LinearLayout) view.findViewById(a.g.ala_person_center_current_exp_panel);
        this.gks = (TextView) view.findViewById(a.g.ala_person_center_current_exp_txt);
        this.gkt = (TextView) view.findViewById(a.g.ala_person_center_current_level);
        this.gku = (TextView) view.findViewById(a.g.ala_person_center_next_level);
        this.gkw = (LinearLayout) view.findViewById(a.g.ala_person_center_next_level_bg);
        this.gkv = view.findViewById(a.g.ala_person_center_current_level_bg);
    }

    public void n(long j, int i) {
        long j2 = com.baidu.tieba.ala.live.personcenter.a.gjF[i - 1];
        int i2 = i + 1;
        this.gks.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_exp, String.valueOf(j + "/" + j2)));
        this.gkt.setText(this.mContext.getResources().getString(a.i.sdk_prc_current_level, String.valueOf(i)));
        if (i2 > 40) {
            this.gku.setText("");
        } else {
            this.gku.setText(this.mContext.getResources().getString(a.i.sdk_prc_next_level, String.valueOf(i2)));
        }
        if (j2 != 0) {
            ViewGroup.LayoutParams layoutParams = this.gkv.getLayoutParams();
            layoutParams.width = (int) ((this.gkw.getLayoutParams().width * j) / j2);
            this.gkv.setLayoutParams(layoutParams);
        }
    }

    public void b(AlaPersonCenterExpActivity alaPersonCenterExpActivity, int i) {
        alaPersonCenterExpActivity.getLayoutMode().onModeChanged(this.gkx);
        if (i == 1) {
            this.gks.setAlpha(0.7f);
            this.gks.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.gkt.setAlpha(0.7f);
            this.gkt.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.gku.setAlpha(0.7f);
            this.gku.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
            this.gkv.setAlpha(0.7f);
            this.gkv.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.sdk_prc_current_level_bg));
        }
    }
}
