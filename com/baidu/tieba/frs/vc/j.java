package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes6.dex */
public class j {
    private TextView atD;
    private FrsFragment dTm;
    private NavigationBarCoverTip dXG;
    private int dXH;

    public j(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.dTm = frsFragment;
        this.dXG = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.dXH = 0;
        this.atD = new TextView(this.dTm.getActivity());
        this.atD.setLayoutParams(new LinearLayout.LayoutParams(-1, this.dTm.getResources().getDimensionPixelSize(e.C0200e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.atD.setPadding(this.dTm.getResources().getDimensionPixelSize(e.C0200e.ds34), this.dTm.getResources().getDimensionPixelSize(e.C0200e.ds1), this.dTm.getResources().getDimensionPixelSize(e.C0200e.ds34), 0);
            this.atD.setGravity(3);
        } else {
            this.atD.setPadding(this.dTm.getResources().getDimensionPixelSize(e.C0200e.ds34), 0, this.dTm.getResources().getDimensionPixelSize(e.C0200e.ds34), 0);
            this.atD.setGravity(19);
        }
        this.atD.setTextSize(0, this.dTm.getResources().getDimensionPixelSize(e.C0200e.ds28));
        this.atD.setLineSpacing(this.dTm.getResources().getDimensionPixelSize(e.C0200e.ds2), 1.0f);
        this.atD.setMaxLines(2);
        this.atD.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void nB(String str) {
        String str2;
        if (!ao.isEmpty(str) && this.dXG != null && this.dTm.isPrimary() && this.dXH <= 0) {
            this.dXH++;
            if (str.length() < 20) {
                str2 = this.dTm.getResources().getString(e.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.dTm.getResources().getString(e.j.forum_ueg_tip) + str;
            } else {
                str2 = this.dTm.getResources().getString(e.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.atD.setText(str2);
            al.h(this.atD, e.d.cp_cont_i);
            al.j(this.dXG, e.d.cp_link_tip_a_alpha95);
            this.dXG.a(this.dTm.getActivity(), this.atD, UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.dXG != null) {
            this.dXG.onDestroy();
        }
    }
}
