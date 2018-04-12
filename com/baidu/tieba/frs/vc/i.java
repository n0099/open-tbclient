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
    private FrsFragment dmZ;
    private NavigationBarCoverTip dqX;
    private int dqY;

    public i(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.dmZ = frsFragment;
        this.dqX = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.dqY = 0;
        this.adw = new TextView(this.dmZ.getActivity());
        this.adw.setLayoutParams(new LinearLayout.LayoutParams(-1, this.dmZ.getResources().getDimensionPixelSize(d.e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.adw.setPadding(this.dmZ.getResources().getDimensionPixelSize(d.e.ds34), this.dmZ.getResources().getDimensionPixelSize(d.e.ds1), this.dmZ.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.adw.setGravity(3);
        } else {
            this.adw.setPadding(this.dmZ.getResources().getDimensionPixelSize(d.e.ds34), 0, this.dmZ.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.adw.setGravity(19);
        }
        this.adw.setTextSize(0, this.dmZ.getResources().getDimensionPixelSize(d.e.ds28));
        this.adw.setLineSpacing(this.dmZ.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
        this.adw.setMaxLines(2);
        this.adw.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void lL(String str) {
        String str2;
        if (!an.isEmpty(str) && this.dqX != null && this.dmZ.isPrimary() && this.dqY <= 0) {
            this.dqY++;
            if (str.length() < 20) {
                str2 = this.dmZ.getResources().getString(d.k.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.dmZ.getResources().getString(d.k.forum_ueg_tip) + str;
            } else {
                str2 = this.dmZ.getResources().getString(d.k.forum_ueg_tip) + str.substring(0, 34);
            }
            this.adw.setText(str2);
            ak.h(this.adw, d.C0126d.cp_cont_i);
            this.dqX.removeAllViews();
            this.dqX.addView(this.adw);
            this.dqX.h(this.dmZ.getActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dqX != null) {
            this.dqX.onDestroy();
        }
    }
}
