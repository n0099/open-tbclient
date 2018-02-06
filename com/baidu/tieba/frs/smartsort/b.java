package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.frs.k;
/* loaded from: classes2.dex */
public class b {
    private au ccx;
    private TextView dPd;
    private final i dSV;
    private boolean dTW;
    private int dTX = -1;
    private int duM;

    public b(i iVar) {
        this.duM = 0;
        if (iVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.dSV = iVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.duM = UtilHelper.getStatusBarHeight();
        }
    }

    public void azL() {
        if (this.dTW && this.dTX >= 0) {
            nK(this.dTX);
        }
        this.dTW = false;
    }

    public void nJ(int i) {
        if (i >= 0) {
            gq(true);
            nL(i);
            return;
        }
        gq(false);
        nL(i);
    }

    private void nK(int i) {
        FrameLayout frameLayout;
        String string;
        k auT = this.dSV.auT();
        if (auT != null && auT.getListView() != null && (frameLayout = (FrameLayout) auT.avX()) != null) {
            if (this.dPd == null && this.dSV.getPageContext() != null) {
                this.dPd = new TextView(this.dSV.getPageContext().getPageActivity());
                this.dPd.setTextSize(0, this.dSV.getResources().getDimensionPixelSize(d.e.fontsize28));
                this.dPd.setGravity(17);
            }
            if (this.dPd != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_nodata);
                }
                this.dPd.setText(string);
            }
            aj.s(this.dPd, d.C0140d.common_color_10260);
            aj.r(this.dPd, d.C0140d.cp_cont_g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.t(TbadkCoreApplication.getInst(), d.e.ds56));
            if (auT.avD() != null && auT.avD().getLayoutParams() != null) {
                layoutParams.topMargin = auT.avD().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.ccx == null) {
                this.ccx = new au();
            }
            this.ccx.a(this.dPd, frameLayout, layoutParams, 2000);
            this.dTX = -1;
        }
    }

    public void gq(boolean z) {
        this.dTW = z;
    }

    public void nL(int i) {
        this.dTX = i;
    }

    public void onDestroy() {
        if (this.ccx != null) {
            this.ccx.onDestroy();
        }
    }
}
