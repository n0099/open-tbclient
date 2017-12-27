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
    private au bZX;
    private TextView dHi;
    private final i dKN;
    private boolean dLO;
    private int dLP = -1;
    private int dmX;

    public b(i iVar) {
        this.dmX = 0;
        if (iVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.dKN = iVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dmX = UtilHelper.getStatusBarHeight();
        }
    }

    public void axB() {
        if (this.dLO && this.dLP >= 0) {
            nH(this.dLP);
        }
        this.dLO = false;
    }

    public void nG(int i) {
        if (i >= 0) {
            ga(true);
            nI(i);
            return;
        }
        ga(false);
        nI(i);
    }

    private void nH(int i) {
        FrameLayout frameLayout;
        String string;
        k asV = this.dKN.asV();
        if (asV != null && asV.getListView() != null && (frameLayout = (FrameLayout) asV.atN()) != null) {
            if (this.dHi == null && this.dKN.getPageContext() != null) {
                this.dHi = new TextView(this.dKN.getPageContext().getPageActivity());
                this.dHi.setTextSize(0, this.dKN.getResources().getDimensionPixelSize(d.e.fontsize28));
                this.dHi.setGravity(17);
            }
            if (this.dHi != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_nodata);
                }
                this.dHi.setText(string);
            }
            aj.s(this.dHi, d.C0108d.common_color_10260);
            aj.r(this.dHi, d.C0108d.cp_cont_g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.s(TbadkCoreApplication.getInst(), d.e.ds56));
            if (asV.atv() != null && asV.atv().getLayoutParams() != null) {
                layoutParams.topMargin = asV.atv().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bZX == null) {
                this.bZX = new au();
            }
            this.bZX.a(this.dHi, frameLayout, layoutParams, 2000);
            this.dLP = -1;
        }
    }

    public void ga(boolean z) {
        this.dLO = z;
    }

    public void nI(int i) {
        this.dLP = i;
    }

    public void onDestroy() {
        if (this.bZX != null) {
            this.bZX.onDestroy();
        }
    }
}
