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
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.ci;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c {
    private int bQe;
    private final r bTw;
    private ci bac;
    private TextView ceV;
    private boolean ceW;
    private int ceX = -1;

    public c(r rVar) {
        this.bQe = 0;
        if (rVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.bTw = rVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bQe = UtilHelper.getStatusBarHeight();
        }
    }

    public void adq() {
        if (this.ceW && this.ceX >= 0) {
            iN(this.ceX);
        }
        this.ceW = false;
    }

    public void iM(int i) {
        if (i >= 0) {
            ew(true);
            iO(i);
            return;
        }
        ew(false);
        iO(i);
    }

    private void iN(int i) {
        String string;
        com.baidu.tieba.frs.entelechy.b.d aab = this.bTw.aab();
        au aad = this.bTw.aad();
        if (aad != null && aab != null && aab.abT() != null && (aad.TK() instanceof NoPressedRelativeLayout)) {
            if (this.ceV == null && this.bTw.getPageContext() != null) {
                this.ceV = new TextView(this.bTw.getPageContext().getPageActivity());
                this.ceV.setTextSize(0, this.bTw.getResources().getDimensionPixelSize(w.f.fontsize28));
                this.ceV.setGravity(17);
            }
            if (this.ceV != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.m9getInst().getString(w.l.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.m9getInst().getString(w.l.recommend_frs_refresh_nodata);
                }
                this.ceV.setText(string);
            }
            View abT = aab.abT();
            BdTypeListView listView = aad.getListView();
            if (abT != null && listView != null) {
                aq.j(this.ceV, w.e.common_color_10260);
                aq.i(this.ceV, w.e.cp_cont_g);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, k.g(TbadkCoreApplication.m9getInst(), w.f.ds56));
                layoutParams.addRule(6, w.h.frs_list_content);
                if (aad.aaB() != null && aad.aaB().getLayoutParams() != null) {
                    layoutParams.topMargin = aad.aaB().getLayoutParams().height;
                } else {
                    layoutParams.topMargin = 0;
                }
                if (this.bac == null) {
                    this.bac = new ci();
                }
                this.bac.a(this.ceV, (NoPressedRelativeLayout) aad.TK(), layoutParams, 2000);
                this.ceX = -1;
            }
        }
    }

    public void adr() {
        if (this.ceV != null && this.ceV.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d aab = this.bTw.aab();
            au aad = this.bTw.aad();
            if (aad != null && aab != null && aab.abT() != null && (aad.TK() instanceof NoPressedRelativeLayout)) {
                BdTypeListView listView = aad.getListView();
                View abT = aab.abT();
                if (listView != null) {
                    boolean z = listView.indexOfChild(abT) >= 0;
                    if (this.bac != null && !z && this.ceV.getTop() <= this.bQe) {
                        this.bac.hideTip();
                    }
                }
            }
        }
    }

    public void ew(boolean z) {
        this.ceW = z;
    }

    public void iO(int i) {
        this.ceX = i;
    }

    public void onDestroy() {
        if (this.bac != null) {
            this.bac.onDestroy();
        }
    }
}
