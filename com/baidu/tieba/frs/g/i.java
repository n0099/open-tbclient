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
    private TextView acv;
    private com.baidu.tieba.frs.g cOB;
    private NavigationBarCoverTip dbn;
    private int dbo;

    public i(com.baidu.tieba.frs.g gVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.cOB = gVar;
        this.dbn = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.dbo = 0;
        this.acv = new TextView(this.cOB.getActivity());
        this.acv.setLayoutParams(new LinearLayout.LayoutParams(-1, this.cOB.getResources().getDimensionPixelSize(d.e.ds88)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.acv.setPadding(this.cOB.getResources().getDimensionPixelSize(d.e.ds34), this.cOB.getResources().getDimensionPixelSize(d.e.ds1), this.cOB.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.acv.setGravity(3);
        } else {
            this.acv.setPadding(this.cOB.getResources().getDimensionPixelSize(d.e.ds34), 0, this.cOB.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.acv.setGravity(19);
        }
        this.acv.setTextSize(0, this.cOB.getResources().getDimensionPixelSize(d.e.ds28));
        this.acv.setLineSpacing(this.cOB.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
        this.acv.setMaxLines(2);
        this.acv.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void lc(String str) {
        String str2;
        if (!am.isEmpty(str) && this.dbn != null && this.cOB.isPrimary() && this.dbo <= 0) {
            this.dbo++;
            if (str.length() < 20) {
                str2 = this.cOB.getResources().getString(d.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.cOB.getResources().getString(d.j.forum_ueg_tip) + str;
            } else {
                str2 = this.cOB.getResources().getString(d.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.acv.setText(str2);
            aj.i(this.acv, d.C0095d.cp_cont_i);
            this.dbn.removeAllViews();
            this.dbn.addView(this.acv);
            this.dbn.j(this.cOB.getActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dbn != null) {
            this.dbn.onDestory();
        }
    }
}
