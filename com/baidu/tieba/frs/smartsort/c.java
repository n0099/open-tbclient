package com.baidu.tieba.frs.smartsort;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.frs.cq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c {
    private int bLn;
    private final FrsActivity bVk;
    private cq caV;
    private TextView caW;
    private boolean caX;
    private int caY = -1;

    public c(FrsActivity frsActivity) {
        this.bLn = 0;
        if (frsActivity == null) {
            throw new NullPointerException("FrsActivity is null");
        }
        this.bVk = frsActivity;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bLn = UtilHelper.getStatusBarHeight();
        }
    }

    public void aej() {
        if (this.caX && this.caY >= 0) {
            iy(this.caY);
        }
        this.caX = false;
    }

    public void aek() {
        if (this.caV != null) {
            this.caV.hideTip();
        }
    }

    public void ix(int i) {
        if (i >= 0) {
            es(true);
            iz(i);
            return;
        }
        es(false);
        iz(i);
    }

    private void iy(int i) {
        String string;
        com.baidu.tieba.frs.entelechy.b.d ZZ = this.bVk.ZZ();
        az aab = this.bVk.aab();
        if (aab != null && ZZ != null && ZZ.acC() != null && (aab.abg() instanceof NoPressedRelativeLayout)) {
            if (this.caW == null) {
                this.caW = new TextView(this.bVk.getPageContext().getPageActivity());
                this.caW.setTextSize(0, this.bVk.getResources().getDimensionPixelSize(w.f.fontsize28));
                this.caW.setGravity(17);
            }
            if (i > 0) {
                string = String.format(TbadkCoreApplication.m9getInst().getString(w.l.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.m9getInst().getString(w.l.recommend_frs_refresh_nodata);
            }
            this.caW.setText(string);
            View acC = ZZ.acC();
            BdTypeListView listView = aab.getListView();
            if (acC != null && listView != null) {
                int bottom = acC.getBottom();
                aq.j(this.caW, w.e.common_color_10260);
                aq.i(this.caW, w.e.cp_cont_g);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, k.g(TbadkCoreApplication.m9getInst(), w.f.ds56));
                layoutParams.addRule(6);
                boolean z = aab.aaJ() != null && (aab.aaJ().getBottom() <= acC.getTop() || aab.aaJ().getVisibility() != 0);
                if (listView.indexOfChild(acC) >= 0 && z) {
                    layoutParams.topMargin = bottom;
                    if (this.caV == null) {
                        this.caV = new cq();
                    }
                    this.caV.a(this.caW, (NoPressedRelativeLayout) aab.abg(), layoutParams, 2000);
                }
                this.caY = -1;
            }
        }
    }

    public void ael() {
        if (this.caW != null && this.caW.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d ZZ = this.bVk.ZZ();
            az aab = this.bVk.aab();
            if (aab != null && ZZ != null && ZZ.acC() != null && (aab.abg() instanceof NoPressedRelativeLayout)) {
                BdTypeListView listView = aab.getListView();
                View acC = ZZ.acC();
                if (listView != null) {
                    boolean z = listView.indexOfChild(acC) >= 0;
                    if (this.caW.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.caW.getLayoutParams();
                        if (z && acC.getBottom() > this.bLn) {
                            layoutParams.topMargin = acC.getBottom();
                        } else {
                            layoutParams.topMargin = this.bLn;
                        }
                        this.caW.setLayoutParams(layoutParams);
                    }
                    if (this.caV != null && !z && this.caW.getTop() <= this.bLn) {
                        this.caV.hideTip();
                    }
                }
            }
        }
    }

    public void es(boolean z) {
        this.caX = z;
    }

    public void iz(int i) {
        this.caY = i;
    }

    public void onDestroy() {
        if (this.caV != null) {
            this.caV.onDestroy();
        }
    }
}
