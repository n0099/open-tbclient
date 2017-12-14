package com.baidu.tieba.frs.g;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes.dex */
public class i {
    private TextView acs;
    private com.baidu.tieba.frs.g cOx;
    private NavigationBarCoverTip dbj;
    private int dbk;

    public i(com.baidu.tieba.frs.g gVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.cOx = gVar;
        this.dbj = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.dbk = 0;
        this.acs = new TextView(this.cOx.getActivity());
        this.acs.setLayoutParams(new LinearLayout.LayoutParams(-1, this.cOx.getResources().getDimensionPixelSize(d.e.ds88)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.acs.setPadding(this.cOx.getResources().getDimensionPixelSize(d.e.ds34), this.cOx.getResources().getDimensionPixelSize(d.e.ds1), this.cOx.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.acs.setGravity(3);
        } else {
            this.acs.setPadding(this.cOx.getResources().getDimensionPixelSize(d.e.ds34), 0, this.cOx.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.acs.setGravity(19);
        }
        this.acs.setTextSize(0, this.cOx.getResources().getDimensionPixelSize(d.e.ds28));
        this.acs.setLineSpacing(this.cOx.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
        this.acs.setMaxLines(2);
        this.acs.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void lc(String str) {
        String str2;
        if (!am.isEmpty(str) && this.dbj != null && this.cOx.isPrimary() && this.dbk <= 0) {
            this.dbk++;
            if (str.length() < 20) {
                str2 = this.cOx.getResources().getString(d.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.cOx.getResources().getString(d.j.forum_ueg_tip) + str;
            } else {
                str2 = this.cOx.getResources().getString(d.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.acs.setText(str2);
            aj.i(this.acs, d.C0096d.cp_cont_i);
            this.dbj.removeAllViews();
            this.dbj.addView(this.acs);
            this.dbj.j(this.cOx.getActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dbj != null) {
            this.dbj.onDestory();
        }
    }
}
