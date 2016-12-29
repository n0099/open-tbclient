package com.baidu.tieba.frs.f;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.cs;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class d {
    private final FrsActivity bFI;
    private cs bMD;
    private TextView bME;
    private boolean bMF;
    private int bMG = -1;
    private int bup;

    public d(FrsActivity frsActivity) {
        this.bup = 0;
        if (frsActivity == null) {
            throw new NullPointerException("FrsActivity is null");
        }
        this.bFI = frsActivity;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bup = UtilHelper.getStatusBarHeight();
        }
    }

    public void abj() {
        if (this.bMF && this.bMG >= 0) {
            hI(this.bMG);
        }
        this.bMF = false;
    }

    public void abk() {
        if (this.bMD != null) {
            this.bMD.hideTip();
        }
    }

    public void hH(int i) {
        if (i >= 0) {
            ed(true);
            hJ(i);
            return;
        }
        ed(false);
        hJ(i);
    }

    private void hI(int i) {
        String string;
        com.baidu.tieba.frs.entelechy.b.d Wm = this.bFI.Wm();
        ax Wo = this.bFI.Wo();
        if (Wo != null && Wm != null && Wm.Zf() != null && (Wo.Xv() instanceof NoPressedRelativeLayout)) {
            if (this.bME == null) {
                this.bME = new TextView(this.bFI.getPageContext().getPageActivity());
                this.bME.setTextSize(0, this.bFI.getResources().getDimensionPixelSize(r.e.fontsize28));
                this.bME.setGravity(17);
            }
            if (i > 0) {
                string = String.format(TbadkCoreApplication.m9getInst().getString(r.j.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.m9getInst().getString(r.j.recommend_frs_refresh_nodata);
            }
            this.bME.setText(string);
            View Zf = Wm.Zf();
            BdTypeListView Xm = Wo.Xm();
            if (Zf != null && Xm != null) {
                int bottom = Zf.getBottom();
                ar.k(this.bME, r.d.common_color_10260);
                ar.j((View) this.bME, r.d.cp_cont_g);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, k.e(TbadkCoreApplication.m9getInst(), r.e.ds56));
                layoutParams.addRule(6);
                boolean z = Wo.WU() != null && (Wo.WU().getBottom() <= Zf.getTop() || Wo.WU().getVisibility() != 0);
                if (Xm.indexOfChild(Zf) >= 0 && z) {
                    layoutParams.topMargin = bottom;
                    if (this.bMD == null) {
                        this.bMD = new cs();
                    }
                    this.bMD.a(this.bME, (NoPressedRelativeLayout) Wo.Xv(), layoutParams, 2000);
                }
                this.bMG = -1;
            }
        }
    }

    public void abl() {
        if (this.bME != null && this.bME.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d Wm = this.bFI.Wm();
            ax Wo = this.bFI.Wo();
            if (Wo != null && Wm != null && Wm.Zf() != null && (Wo.Xv() instanceof NoPressedRelativeLayout)) {
                BdTypeListView Xm = Wo.Xm();
                View Zf = Wm.Zf();
                if (Xm != null) {
                    boolean z = Xm.indexOfChild(Zf) >= 0;
                    if (this.bME.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bME.getLayoutParams();
                        if (z && Zf.getBottom() > this.bup) {
                            layoutParams.topMargin = Zf.getBottom();
                        } else {
                            layoutParams.topMargin = this.bup;
                        }
                        this.bME.setLayoutParams(layoutParams);
                    }
                    if (this.bMD != null && !z && this.bME.getTop() <= this.bup) {
                        this.bMD.hideTip();
                    }
                }
            }
        }
    }

    public void ed(boolean z) {
        this.bMF = z;
    }

    public void hJ(int i) {
        this.bMG = i;
    }

    public void onDestroy() {
        if (this.bMD != null) {
            this.bMD.onDestroy();
        }
    }
}
