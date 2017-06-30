package com.baidu.tieba.frs.smartsort;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.cj;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c {
    private int bXb;
    private cj bbT;
    private final r cbE;
    private TextView cnk;
    private boolean cnl;
    private int cnm = -1;

    public c(r rVar) {
        this.bXb = 0;
        if (rVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.cbE = rVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bXb = UtilHelper.getStatusBarHeight();
        }
    }

    public void ahi() {
        if (this.cnl && this.cnm >= 0) {
            iZ(this.cnm);
        }
        this.cnl = false;
    }

    public void iY(int i) {
        if (i >= 0) {
            eO(true);
            ja(i);
            return;
        }
        eO(false);
        ja(i);
    }

    private void iZ(int i) {
        String string;
        com.baidu.tieba.frs.entelechy.b.d adS = this.cbE.adS();
        av adU = this.cbE.adU();
        if (adU != null && adS != null && adS.afK() != null && (adU.Vf() instanceof NoPressedRelativeLayout)) {
            if (this.cnk == null && this.cbE.getPageContext() != null) {
                this.cnk = new TextView(this.cbE.getPageContext().getPageActivity());
                this.cnk.setTextSize(0, this.cbE.getResources().getDimensionPixelSize(w.f.fontsize28));
                this.cnk.setGravity(17);
            }
            if (this.cnk != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.m9getInst().getString(w.l.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.m9getInst().getString(w.l.recommend_frs_refresh_nodata);
                }
                this.cnk.setText(string);
            }
            View afK = adS.afK();
            BdTypeListView listView = adU.getListView();
            if (afK != null && listView != null) {
                as.j(this.cnk, w.e.common_color_10260);
                as.i(this.cnk, w.e.cp_cont_g);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, k.g(TbadkCoreApplication.m9getInst(), w.f.ds56));
                layoutParams.addRule(6, w.h.frs_list_content);
                if (adU.aer() != null && adU.aer().getLayoutParams() != null) {
                    layoutParams.topMargin = adU.aer().getLayoutParams().height;
                } else {
                    layoutParams.topMargin = 0;
                }
                if (this.bbT == null) {
                    this.bbT = new cj();
                }
                this.bbT.a(this.cnk, (NoPressedRelativeLayout) adU.Vf(), layoutParams, 2000);
                this.cnm = -1;
            }
        }
    }

    public void ahj() {
        if (this.cnk != null && this.cnk.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d adS = this.cbE.adS();
            av adU = this.cbE.adU();
            if (adU != null && adS != null && adS.afK() != null && (adU.Vf() instanceof NoPressedRelativeLayout)) {
                BdTypeListView listView = adU.getListView();
                View afK = adS.afK();
                if (listView != null) {
                    boolean z = listView.indexOfChild(afK) >= 0;
                    if (this.bbT != null && !z && this.cnk.getTop() <= this.bXb) {
                        this.bbT.hideTip();
                    }
                }
            }
        }
    }

    public void eO(boolean z) {
        this.cnl = z;
    }

    public void ja(int i) {
        this.cnm = i;
    }

    public void onDestroy() {
        if (this.bbT != null) {
            this.bbT.onDestroy();
        }
    }
}
