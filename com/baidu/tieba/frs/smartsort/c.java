package com.baidu.tieba.frs.smartsort;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.co;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c {
    private int bBW;
    private final FrsActivity bLZ;
    private co bSR;
    private TextView bSS;
    private boolean bST;
    private int bSU = -1;

    public c(FrsActivity frsActivity) {
        this.bBW = 0;
        if (frsActivity == null) {
            throw new NullPointerException("FrsActivity is null");
        }
        this.bLZ = frsActivity;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bBW = UtilHelper.getStatusBarHeight();
        }
    }

    public void acq() {
        if (this.bST && this.bSU >= 0) {
            iv(this.bSU);
        }
        this.bST = false;
    }

    public void acr() {
        if (this.bSR != null) {
            this.bSR.hideTip();
        }
    }

    public void iu(int i) {
        if (i >= 0) {
            ei(true);
            iw(i);
            return;
        }
        ei(false);
        iw(i);
    }

    private void iv(int i) {
        String string;
        com.baidu.tieba.frs.entelechy.b.d XD = this.bLZ.XD();
        ax XF = this.bLZ.XF();
        if (XF != null && XD != null && XD.aah() != null && (XF.YI() instanceof NoPressedRelativeLayout)) {
            if (this.bSS == null) {
                this.bSS = new TextView(this.bLZ.getPageContext().getPageActivity());
                this.bSS.setTextSize(0, this.bLZ.getResources().getDimensionPixelSize(r.f.fontsize28));
                this.bSS.setGravity(17);
            }
            if (i > 0) {
                string = String.format(TbadkCoreApplication.m9getInst().getString(r.l.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.m9getInst().getString(r.l.recommend_frs_refresh_nodata);
            }
            this.bSS.setText(string);
            View aah = XD.aah();
            BdTypeListView Iv = XF.Iv();
            if (aah != null && Iv != null) {
                int bottom = aah.getBottom();
                ap.j((View) this.bSS, r.e.common_color_10260);
                ap.i((View) this.bSS, r.e.cp_cont_g);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, k.e(TbadkCoreApplication.m9getInst(), r.f.ds56));
                layoutParams.addRule(6);
                boolean z = XF.Yl() != null && (XF.Yl().getBottom() <= aah.getTop() || XF.Yl().getVisibility() != 0);
                if (Iv.indexOfChild(aah) >= 0 && z) {
                    layoutParams.topMargin = bottom;
                    if (this.bSR == null) {
                        this.bSR = new co();
                    }
                    this.bSR.a(this.bSS, (NoPressedRelativeLayout) XF.YI(), layoutParams, 2000);
                }
                this.bSU = -1;
            }
        }
    }

    public void acs() {
        if (this.bSS != null && this.bSS.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d XD = this.bLZ.XD();
            ax XF = this.bLZ.XF();
            if (XF != null && XD != null && XD.aah() != null && (XF.YI() instanceof NoPressedRelativeLayout)) {
                BdTypeListView Iv = XF.Iv();
                View aah = XD.aah();
                if (Iv != null) {
                    boolean z = Iv.indexOfChild(aah) >= 0;
                    if (this.bSS.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bSS.getLayoutParams();
                        if (z && aah.getBottom() > this.bBW) {
                            layoutParams.topMargin = aah.getBottom();
                        } else {
                            layoutParams.topMargin = this.bBW;
                        }
                        this.bSS.setLayoutParams(layoutParams);
                    }
                    if (this.bSR != null && !z && this.bSS.getTop() <= this.bBW) {
                        this.bSR.hideTip();
                    }
                }
            }
        }
    }

    public void ei(boolean z) {
        this.bST = z;
    }

    public void iw(int i) {
        this.bSU = i;
    }

    public void onDestroy() {
        if (this.bSR != null) {
            this.bSR.onDestroy();
        }
    }
}
