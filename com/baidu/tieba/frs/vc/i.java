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
    private FrsFragment dof;
    private NavigationBarCoverTip dsc;
    private int dsd;

    public i(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.dof = frsFragment;
        this.dsc = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.dsd = 0;
        this.adw = new TextView(this.dof.getActivity());
        this.adw.setLayoutParams(new LinearLayout.LayoutParams(-1, this.dof.getResources().getDimensionPixelSize(d.e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.adw.setPadding(this.dof.getResources().getDimensionPixelSize(d.e.ds34), this.dof.getResources().getDimensionPixelSize(d.e.ds1), this.dof.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.adw.setGravity(3);
        } else {
            this.adw.setPadding(this.dof.getResources().getDimensionPixelSize(d.e.ds34), 0, this.dof.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.adw.setGravity(19);
        }
        this.adw.setTextSize(0, this.dof.getResources().getDimensionPixelSize(d.e.ds28));
        this.adw.setLineSpacing(this.dof.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
        this.adw.setMaxLines(2);
        this.adw.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void lO(String str) {
        String str2;
        if (!an.isEmpty(str) && this.dsc != null && this.dof.isPrimary() && this.dsd <= 0) {
            this.dsd++;
            if (str.length() < 20) {
                str2 = this.dof.getResources().getString(d.k.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.dof.getResources().getString(d.k.forum_ueg_tip) + str;
            } else {
                str2 = this.dof.getResources().getString(d.k.forum_ueg_tip) + str.substring(0, 34);
            }
            this.adw.setText(str2);
            ak.h(this.adw, d.C0126d.cp_cont_i);
            this.dsc.removeAllViews();
            this.dsc.addView(this.adw);
            this.dsc.h(this.dof.getActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dsc != null) {
            this.dsc.onDestroy();
        }
    }
}
