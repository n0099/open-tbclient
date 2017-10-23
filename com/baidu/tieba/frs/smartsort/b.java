package com.baidu.tieba.frs.smartsort;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.i;
/* loaded from: classes.dex */
public class b {
    private as bgk;
    private TextView cEj;
    private int cFA = -1;
    private boolean cFz;
    private int chN;
    private final com.baidu.tieba.frs.f cwW;

    public b(com.baidu.tieba.frs.f fVar) {
        this.chN = 0;
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.cwW = fVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.chN = UtilHelper.getStatusBarHeight();
        }
    }

    public void alm() {
        if (this.cFz && this.cFA >= 0) {
            jP(this.cFA);
        }
        this.cFz = false;
    }

    public void jO(int i) {
        if (i >= 0) {
            fe(true);
            jQ(i);
            return;
        }
        fe(false);
        jQ(i);
    }

    private void jP(int i) {
        String string;
        com.baidu.tieba.frs.entelechy.b.d agN = this.cwW.agN();
        i agP = this.cwW.agP();
        if (agP != null && agN != null && agN.ajo() != null && (agP.ahG() instanceof NoPressedRelativeLayout)) {
            if (this.cEj == null && this.cwW.getPageContext() != null) {
                this.cEj = new TextView(this.cwW.getPageContext().getPageActivity());
                this.cEj.setTextSize(0, this.cwW.getResources().getDimensionPixelSize(d.f.fontsize28));
                this.cEj.setGravity(17);
            }
            if (this.cEj != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_nodata);
                }
                this.cEj.setText(string);
            }
            View ajo = agN.ajo();
            BdTypeListView listView = agP.getListView();
            if (ajo != null && listView != null) {
                aj.j(this.cEj, d.e.common_color_10260);
                aj.i(this.cEj, d.e.cp_cont_g);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.f(TbadkCoreApplication.getInst(), d.f.ds56));
                layoutParams.addRule(6, d.h.frs_list_content);
                if (agP.ahm() != null && agP.ahm().getLayoutParams() != null) {
                    layoutParams.topMargin = agP.ahm().getLayoutParams().height;
                } else {
                    layoutParams.topMargin = 0;
                }
                if (this.bgk == null) {
                    this.bgk = new as();
                }
                this.bgk.a(this.cEj, (NoPressedRelativeLayout) agP.ahG(), layoutParams, 2000);
                this.cFA = -1;
            }
        }
    }

    public void aln() {
        if (this.cEj != null && this.cEj.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d agN = this.cwW.agN();
            i agP = this.cwW.agP();
            if (agP != null && agN != null && agN.ajo() != null && (agP.ahG() instanceof NoPressedRelativeLayout)) {
                BdTypeListView listView = agP.getListView();
                View ajo = agN.ajo();
                if (listView != null) {
                    boolean z = listView.indexOfChild(ajo) >= 0;
                    if (this.bgk != null && !z && this.cEj.getTop() <= this.chN) {
                        this.bgk.hideTip();
                    }
                }
            }
        }
    }

    public void fe(boolean z) {
        this.cFz = z;
    }

    public void jQ(int i) {
        this.cFA = i;
    }

    public void onDestroy() {
        if (this.bgk != null) {
            this.bgk.onDestroy();
        }
    }
}
