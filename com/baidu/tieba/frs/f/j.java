package com.baidu.tieba.frs.f;

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
    private TextView aQK;
    private com.baidu.tieba.frs.i dPK;
    private NavigationBarCoverTip dSJ;
    private int dSK;

    public j(com.baidu.tieba.frs.i iVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.dPK = iVar;
        this.dSJ = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.dSK = 0;
        this.aQK = new TextView(this.dPK.getActivity());
        this.aQK.setLayoutParams(new LinearLayout.LayoutParams(-1, this.dPK.getResources().getDimensionPixelSize(d.e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.aQK.setPadding(this.dPK.getResources().getDimensionPixelSize(d.e.ds34), this.dPK.getResources().getDimensionPixelSize(d.e.ds1), this.dPK.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.aQK.setGravity(3);
        } else {
            this.aQK.setPadding(this.dPK.getResources().getDimensionPixelSize(d.e.ds34), 0, this.dPK.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.aQK.setGravity(19);
        }
        this.aQK.setTextSize(0, this.dPK.getResources().getDimensionPixelSize(d.e.ds28));
        this.aQK.setLineSpacing(this.dPK.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
        this.aQK.setMaxLines(2);
        this.aQK.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void lz(String str) {
        String str2;
        if (!am.isEmpty(str) && this.dSJ != null && this.dPK.isPrimary() && this.dSK <= 0) {
            this.dSK++;
            if (str.length() < 20) {
                str2 = this.dPK.getResources().getString(d.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.dPK.getResources().getString(d.j.forum_ueg_tip) + str;
            } else {
                str2 = this.dPK.getResources().getString(d.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.aQK.setText(str2);
            aj.r(this.aQK, d.C0108d.cp_cont_i);
            this.dSJ.removeAllViews();
            this.dSJ.addView(this.aQK);
            this.dSJ.h(this.dPK.getActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dSJ != null) {
            this.dSJ.onDestroy();
        }
    }
}
