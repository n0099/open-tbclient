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
    private ar beO;
    private TextView cCK;
    private boolean cEa;
    private int cEb = -1;
    private int chP;
    private final com.baidu.tieba.frs.f cvA;

    public b(com.baidu.tieba.frs.f fVar) {
        this.chP = 0;
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.cvA = fVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.chP = UtilHelper.getStatusBarHeight();
        }
    }

    public void alc() {
        if (this.cEa && this.cEb >= 0) {
            jG(this.cEb);
        }
        this.cEa = false;
    }

    public void jF(int i) {
        if (i >= 0) {
            fk(true);
            jH(i);
            return;
        }
        fk(false);
        jH(i);
    }

    private void jG(int i) {
        String string;
        com.baidu.tieba.frs.entelechy.b.d agL = this.cvA.agL();
        i agN = this.cvA.agN();
        if (agN != null && agL != null && agL.ajd() != null && (agN.Xn() instanceof NoPressedRelativeLayout)) {
            if (this.cCK == null && this.cvA.getPageContext() != null) {
                this.cCK = new TextView(this.cvA.getPageContext().getPageActivity());
                this.cCK.setTextSize(0, this.cvA.getResources().getDimensionPixelSize(d.f.fontsize28));
                this.cCK.setGravity(17);
            }
            if (this.cCK != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_nodata);
                }
                this.cCK.setText(string);
            }
            View ajd = agL.ajd();
            BdTypeListView listView = agN.getListView();
            if (ajd != null && listView != null) {
                aj.j(this.cCK, d.e.common_color_10260);
                aj.i(this.cCK, d.e.cp_cont_g);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, k.g(TbadkCoreApplication.getInst(), d.f.ds56));
                layoutParams.addRule(6, d.h.frs_list_content);
                if (agN.ahn() != null && agN.ahn().getLayoutParams() != null) {
                    layoutParams.topMargin = agN.ahn().getLayoutParams().height;
                } else {
                    layoutParams.topMargin = 0;
                }
                if (this.beO == null) {
                    this.beO = new ar();
                }
                this.beO.a(this.cCK, (NoPressedRelativeLayout) agN.Xn(), layoutParams, 2000);
                this.cEb = -1;
            }
        }
    }

    public void ald() {
        if (this.cCK != null && this.cCK.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d agL = this.cvA.agL();
            i agN = this.cvA.agN();
            if (agN != null && agL != null && agL.ajd() != null && (agN.Xn() instanceof NoPressedRelativeLayout)) {
                BdTypeListView listView = agN.getListView();
                View ajd = agL.ajd();
                if (listView != null) {
                    boolean z = listView.indexOfChild(ajd) >= 0;
                    if (this.beO != null && !z && this.cCK.getTop() <= this.chP) {
                        this.beO.hideTip();
                    }
                }
            }
        }
    }

    public void fk(boolean z) {
        this.cEa = z;
    }

    public void jH(int i) {
        this.cEb = i;
    }

    public void onDestroy() {
        if (this.beO != null) {
            this.beO.onDestroy();
        }
    }
}
