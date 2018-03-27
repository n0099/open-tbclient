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
    private au ccn;
    private TextView dOW;
    private final i dSO;
    private boolean dTP;
    private int dTQ = -1;
    private int duD;

    public b(i iVar) {
        this.duD = 0;
        if (iVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.dSO = iVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.duD = UtilHelper.getStatusBarHeight();
        }
    }

    public void azM() {
        if (this.dTP && this.dTQ >= 0) {
            nK(this.dTQ);
        }
        this.dTP = false;
    }

    public void nJ(int i) {
        if (i >= 0) {
            gs(true);
            nL(i);
            return;
        }
        gs(false);
        nL(i);
    }

    private void nK(int i) {
        FrameLayout frameLayout;
        String string;
        k auT = this.dSO.auT();
        if (auT != null && auT.getListView() != null && (frameLayout = (FrameLayout) auT.avY()) != null) {
            if (this.dOW == null && this.dSO.getPageContext() != null) {
                this.dOW = new TextView(this.dSO.getPageContext().getPageActivity());
                this.dOW.setTextSize(0, this.dSO.getResources().getDimensionPixelSize(d.e.fontsize28));
                this.dOW.setGravity(17);
            }
            if (this.dOW != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_nodata);
                }
                this.dOW.setText(string);
            }
            aj.s(this.dOW, d.C0141d.common_color_10260);
            aj.r(this.dOW, d.C0141d.cp_cont_g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.t(TbadkCoreApplication.getInst(), d.e.ds56));
            if (auT.avE() != null && auT.avE().getLayoutParams() != null) {
                layoutParams.topMargin = auT.avE().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.ccn == null) {
                this.ccn = new au();
            }
            this.ccn.a(this.dOW, frameLayout, layoutParams, 2000);
            this.dTQ = -1;
        }
    }

    public void gs(boolean z) {
        this.dTP = z;
    }

    public void nL(int i) {
        this.dTQ = i;
    }

    public void onDestroy() {
        if (this.ccn != null) {
            this.ccn.onDestroy();
        }
    }
}
