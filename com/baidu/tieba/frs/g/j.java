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
    private TextView aRY;
    private com.baidu.tieba.frs.i dSJ;
    private NavigationBarCoverTip dVQ;
    private int dVR;

    public j(com.baidu.tieba.frs.i iVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.dSJ = iVar;
        this.dVQ = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.dVR = 0;
        this.aRY = new TextView(this.dSJ.getActivity());
        this.aRY.setLayoutParams(new LinearLayout.LayoutParams(-1, this.dSJ.getResources().getDimensionPixelSize(d.e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.aRY.setPadding(this.dSJ.getResources().getDimensionPixelSize(d.e.ds34), this.dSJ.getResources().getDimensionPixelSize(d.e.ds1), this.dSJ.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.aRY.setGravity(3);
        } else {
            this.aRY.setPadding(this.dSJ.getResources().getDimensionPixelSize(d.e.ds34), 0, this.dSJ.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.aRY.setGravity(19);
        }
        this.aRY.setTextSize(0, this.dSJ.getResources().getDimensionPixelSize(d.e.ds28));
        this.aRY.setLineSpacing(this.dSJ.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
        this.aRY.setMaxLines(2);
        this.aRY.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void lI(String str) {
        String str2;
        if (!am.isEmpty(str) && this.dVQ != null && this.dSJ.isPrimary() && this.dVR <= 0) {
            this.dVR++;
            if (str.length() < 20) {
                str2 = this.dSJ.getResources().getString(d.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.dSJ.getResources().getString(d.j.forum_ueg_tip) + str;
            } else {
                str2 = this.dSJ.getResources().getString(d.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.aRY.setText(str2);
            aj.r(this.aRY, d.C0141d.cp_cont_i);
            this.dVQ.removeAllViews();
            this.dVQ.addView(this.aRY);
            this.dVQ.h(this.dSJ.getActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dVQ != null) {
            this.dVQ.onDestroy();
        }
    }
}
