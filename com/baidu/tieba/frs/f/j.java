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
    private TextView aQI;
    private com.baidu.tieba.frs.i dKN;
    private NavigationBarCoverTip dNM;
    private int dNN;

    public j(com.baidu.tieba.frs.i iVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.dKN = iVar;
        this.dNM = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.dNN = 0;
        this.aQI = new TextView(this.dKN.getActivity());
        this.aQI.setLayoutParams(new LinearLayout.LayoutParams(-1, this.dKN.getResources().getDimensionPixelSize(d.e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.aQI.setPadding(this.dKN.getResources().getDimensionPixelSize(d.e.ds34), this.dKN.getResources().getDimensionPixelSize(d.e.ds1), this.dKN.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.aQI.setGravity(3);
        } else {
            this.aQI.setPadding(this.dKN.getResources().getDimensionPixelSize(d.e.ds34), 0, this.dKN.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.aQI.setGravity(19);
        }
        this.aQI.setTextSize(0, this.dKN.getResources().getDimensionPixelSize(d.e.ds28));
        this.aQI.setLineSpacing(this.dKN.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
        this.aQI.setMaxLines(2);
        this.aQI.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void lk(String str) {
        String str2;
        if (!am.isEmpty(str) && this.dNM != null && this.dKN.isPrimary() && this.dNN <= 0) {
            this.dNN++;
            if (str.length() < 20) {
                str2 = this.dKN.getResources().getString(d.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.dKN.getResources().getString(d.j.forum_ueg_tip) + str;
            } else {
                str2 = this.dKN.getResources().getString(d.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.aQI.setText(str2);
            aj.r(this.aQI, d.C0108d.cp_cont_i);
            this.dNM.removeAllViews();
            this.dNM.addView(this.aQI);
            this.dNM.j(this.dKN.getActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dNM != null) {
            this.dNM.onDestroy();
        }
    }
}
