package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class i {
    private TextView adw;
    private FrsFragment dmW;
    private NavigationBarCoverTip dqU;
    private int dqV;

    public i(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.dmW = frsFragment;
        this.dqU = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.dqV = 0;
        this.adw = new TextView(this.dmW.getActivity());
        this.adw.setLayoutParams(new LinearLayout.LayoutParams(-1, this.dmW.getResources().getDimensionPixelSize(d.e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.adw.setPadding(this.dmW.getResources().getDimensionPixelSize(d.e.ds34), this.dmW.getResources().getDimensionPixelSize(d.e.ds1), this.dmW.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.adw.setGravity(3);
        } else {
            this.adw.setPadding(this.dmW.getResources().getDimensionPixelSize(d.e.ds34), 0, this.dmW.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.adw.setGravity(19);
        }
        this.adw.setTextSize(0, this.dmW.getResources().getDimensionPixelSize(d.e.ds28));
        this.adw.setLineSpacing(this.dmW.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
        this.adw.setMaxLines(2);
        this.adw.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void lL(String str) {
        String str2;
        if (!an.isEmpty(str) && this.dqU != null && this.dmW.isPrimary() && this.dqV <= 0) {
            this.dqV++;
            if (str.length() < 20) {
                str2 = this.dmW.getResources().getString(d.k.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.dmW.getResources().getString(d.k.forum_ueg_tip) + str;
            } else {
                str2 = this.dmW.getResources().getString(d.k.forum_ueg_tip) + str.substring(0, 34);
            }
            this.adw.setText(str2);
            ak.h(this.adw, d.C0126d.cp_cont_i);
            this.dqU.removeAllViews();
            this.dqU.addView(this.adw);
            this.dqU.h(this.dmW.getActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dqU != null) {
            this.dqU.onDestroy();
        }
    }
}
