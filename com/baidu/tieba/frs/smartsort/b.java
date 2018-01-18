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
    private au cae;
    private TextView dLJ;
    private final i dPp;
    private boolean dQq;
    private int dQr = -1;
    private int dry;

    public b(i iVar) {
        this.dry = 0;
        if (iVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.dPp = iVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dry = UtilHelper.getStatusBarHeight();
        }
    }

    public void ayE() {
        if (this.dQq && this.dQr >= 0) {
            nK(this.dQr);
        }
        this.dQq = false;
    }

    public void nJ(int i) {
        if (i >= 0) {
            ge(true);
            nL(i);
            return;
        }
        ge(false);
        nL(i);
    }

    private void nK(int i) {
        FrameLayout frameLayout;
        String string;
        k atY = this.dPp.atY();
        if (atY != null && atY.getListView() != null && (frameLayout = (FrameLayout) atY.auQ()) != null) {
            if (this.dLJ == null && this.dPp.getPageContext() != null) {
                this.dLJ = new TextView(this.dPp.getPageContext().getPageActivity());
                this.dLJ.setTextSize(0, this.dPp.getResources().getDimensionPixelSize(d.e.fontsize28));
                this.dLJ.setGravity(17);
            }
            if (this.dLJ != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_nodata);
                }
                this.dLJ.setText(string);
            }
            aj.s(this.dLJ, d.C0107d.common_color_10260);
            aj.r(this.dLJ, d.C0107d.cp_cont_g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.s(TbadkCoreApplication.getInst(), d.e.ds56));
            if (atY.auy() != null && atY.auy().getLayoutParams() != null) {
                layoutParams.topMargin = atY.auy().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.cae == null) {
                this.cae = new au();
            }
            this.cae.a(this.dLJ, frameLayout, layoutParams, 2000);
            this.dQr = -1;
        }
    }

    public void ge(boolean z) {
        this.dQq = z;
    }

    public void nL(int i) {
        this.dQr = i;
    }

    public void onDestroy() {
        if (this.cae != null) {
            this.cae.onDestroy();
        }
    }
}
