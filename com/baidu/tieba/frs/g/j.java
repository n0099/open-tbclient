package com.baidu.tieba.frs.g;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class j {
    private TextView aSj;
    private com.baidu.tieba.frs.i dSV;
    private NavigationBarCoverTip dWc;
    private int dWd;

    public j(com.baidu.tieba.frs.i iVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.dSV = iVar;
        this.dWc = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.dWd = 0;
        this.aSj = new TextView(this.dSV.getActivity());
        this.aSj.setLayoutParams(new LinearLayout.LayoutParams(-1, this.dSV.getResources().getDimensionPixelSize(d.e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.aSj.setPadding(this.dSV.getResources().getDimensionPixelSize(d.e.ds34), this.dSV.getResources().getDimensionPixelSize(d.e.ds1), this.dSV.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.aSj.setGravity(3);
        } else {
            this.aSj.setPadding(this.dSV.getResources().getDimensionPixelSize(d.e.ds34), 0, this.dSV.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.aSj.setGravity(19);
        }
        this.aSj.setTextSize(0, this.dSV.getResources().getDimensionPixelSize(d.e.ds28));
        this.aSj.setLineSpacing(this.dSV.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
        this.aSj.setMaxLines(2);
        this.aSj.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void lI(String str) {
        String str2;
        if (!am.isEmpty(str) && this.dWc != null && this.dSV.isPrimary() && this.dWd <= 0) {
            this.dWd++;
            if (str.length() < 20) {
                str2 = this.dSV.getResources().getString(d.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.dSV.getResources().getString(d.j.forum_ueg_tip) + str;
            } else {
                str2 = this.dSV.getResources().getString(d.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.aSj.setText(str2);
            aj.r(this.aSj, d.C0140d.cp_cont_i);
            this.dWc.removeAllViews();
            this.dWc.addView(this.aSj);
            this.dWc.h(this.dSV.getActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dWc != null) {
            this.dWc.onDestroy();
        }
    }
}
