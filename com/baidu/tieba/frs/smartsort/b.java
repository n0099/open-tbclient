package com.baidu.tieba.frs.smartsort;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.i;
/* loaded from: classes.dex */
public class b {
    private ar beL;
    private TextView cDC;
    private boolean cES;
    private int cET = -1;
    private int ciI;
    private final com.baidu.tieba.frs.f cws;

    public b(com.baidu.tieba.frs.f fVar) {
        this.ciI = 0;
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.cws = fVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.ciI = UtilHelper.getStatusBarHeight();
        }
    }

    public void aln() {
        if (this.cES && this.cET >= 0) {
            jI(this.cET);
        }
        this.cES = false;
    }

    public void jH(int i) {
        if (i >= 0) {
            fl(true);
            jJ(i);
            return;
        }
        fl(false);
        jJ(i);
    }

    private void jI(int i) {
        String string;
        com.baidu.tieba.frs.entelechy.b.d agW = this.cws.agW();
        i agY = this.cws.agY();
        if (agY != null && agW != null && agW.ajo() != null && (agY.Xy() instanceof NoPressedRelativeLayout)) {
            if (this.cDC == null && this.cws.getPageContext() != null) {
                this.cDC = new TextView(this.cws.getPageContext().getPageActivity());
                this.cDC.setTextSize(0, this.cws.getResources().getDimensionPixelSize(d.f.fontsize28));
                this.cDC.setGravity(17);
            }
            if (this.cDC != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_nodata);
                }
                this.cDC.setText(string);
            }
            View ajo = agW.ajo();
            BdTypeListView listView = agY.getListView();
            if (ajo != null && listView != null) {
                aj.j(this.cDC, d.e.common_color_10260);
                aj.i(this.cDC, d.e.cp_cont_g);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, k.f(TbadkCoreApplication.getInst(), d.f.ds56));
                layoutParams.addRule(6, d.h.frs_list_content);
                if (agY.ahy() != null && agY.ahy().getLayoutParams() != null) {
                    layoutParams.topMargin = agY.ahy().getLayoutParams().height;
                } else {
                    layoutParams.topMargin = 0;
                }
                if (this.beL == null) {
                    this.beL = new ar();
                }
                this.beL.a(this.cDC, (NoPressedRelativeLayout) agY.Xy(), layoutParams, 2000);
                this.cET = -1;
            }
        }
    }

    public void alo() {
        if (this.cDC != null && this.cDC.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d agW = this.cws.agW();
            i agY = this.cws.agY();
            if (agY != null && agW != null && agW.ajo() != null && (agY.Xy() instanceof NoPressedRelativeLayout)) {
                BdTypeListView listView = agY.getListView();
                View ajo = agW.ajo();
                if (listView != null) {
                    boolean z = listView.indexOfChild(ajo) >= 0;
                    if (this.beL != null && !z && this.cDC.getTop() <= this.ciI) {
                        this.beL.hideTip();
                    }
                }
            }
        }
    }

    public void fl(boolean z) {
        this.cES = z;
    }

    public void jJ(int i) {
        this.cET = i;
    }

    public void onDestroy() {
        if (this.beL != null) {
            this.beL.onDestroy();
        }
    }
}
