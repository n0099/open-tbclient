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
    private TextView aSa;
    private com.baidu.tieba.frs.i dSO;
    private NavigationBarCoverTip dVW;
    private int dVX;

    public j(com.baidu.tieba.frs.i iVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.dSO = iVar;
        this.dVW = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.dVX = 0;
        this.aSa = new TextView(this.dSO.getActivity());
        this.aSa.setLayoutParams(new LinearLayout.LayoutParams(-1, this.dSO.getResources().getDimensionPixelSize(d.e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.aSa.setPadding(this.dSO.getResources().getDimensionPixelSize(d.e.ds34), this.dSO.getResources().getDimensionPixelSize(d.e.ds1), this.dSO.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.aSa.setGravity(3);
        } else {
            this.aSa.setPadding(this.dSO.getResources().getDimensionPixelSize(d.e.ds34), 0, this.dSO.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.aSa.setGravity(19);
        }
        this.aSa.setTextSize(0, this.dSO.getResources().getDimensionPixelSize(d.e.ds28));
        this.aSa.setLineSpacing(this.dSO.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
        this.aSa.setMaxLines(2);
        this.aSa.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void lI(String str) {
        String str2;
        if (!am.isEmpty(str) && this.dVW != null && this.dSO.isPrimary() && this.dVX <= 0) {
            this.dVX++;
            if (str.length() < 20) {
                str2 = this.dSO.getResources().getString(d.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.dSO.getResources().getString(d.j.forum_ueg_tip) + str;
            } else {
                str2 = this.dSO.getResources().getString(d.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.aSa.setText(str2);
            aj.r(this.aSa, d.C0141d.cp_cont_i);
            this.dVW.removeAllViews();
            this.dVW.addView(this.aSa);
            this.dVW.h(this.dSO.getActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dVW != null) {
            this.dVW.onDestroy();
        }
    }
}
