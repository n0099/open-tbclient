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
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.g;
import com.baidu.tieba.frs.j;
/* loaded from: classes.dex */
public class b {
    private at bmJ;
    private final g cOx;
    private TextView cUT;
    private boolean cYH;
    private int cYI = -1;
    private int cyv;

    public b(g gVar) {
        this.cyv = 0;
        if (gVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.cOx = gVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cyv = UtilHelper.getStatusBarHeight();
        }
    }

    public void aqo() {
        if (this.cYH && this.cYI >= 0) {
            kL(this.cYI);
        }
        this.cYH = false;
    }

    public void kK(int i) {
        if (i >= 0) {
            fA(true);
            kM(i);
            return;
        }
        fA(false);
        kM(i);
    }

    private void kL(int i) {
        String string;
        com.baidu.tieba.frs.entelechy.b.d all = this.cOx.all();
        j aln = this.cOx.aln();
        if (aln != null && all != null && all.anS() != null && (aln.WQ() instanceof NoPressedRelativeLayout)) {
            if (this.cUT == null && this.cOx.getPageContext() != null) {
                this.cUT = new TextView(this.cOx.getPageContext().getPageActivity());
                this.cUT.setTextSize(0, this.cOx.getResources().getDimensionPixelSize(d.e.fontsize28));
                this.cUT.setGravity(17);
            }
            if (this.cUT != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_nodata);
                }
                this.cUT.setText(string);
            }
            View anS = all.anS();
            BdTypeListView listView = aln.getListView();
            if (anS != null && listView != null) {
                aj.j(this.cUT, d.C0096d.common_color_10260);
                aj.i(this.cUT, d.C0096d.cp_cont_g);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.f(TbadkCoreApplication.getInst(), d.e.ds56));
                layoutParams.addRule(6, d.g.frs_list_content);
                if (aln.alK() != null && aln.alK().getLayoutParams() != null) {
                    layoutParams.topMargin = aln.alK().getLayoutParams().height;
                } else {
                    layoutParams.topMargin = 0;
                }
                if (this.bmJ == null) {
                    this.bmJ = new at();
                }
                this.bmJ.a(this.cUT, (NoPressedRelativeLayout) aln.WQ(), layoutParams, 2000);
                this.cYI = -1;
            }
        }
    }

    public void aqp() {
        if (this.cUT != null && this.cUT.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d all = this.cOx.all();
            j aln = this.cOx.aln();
            if (aln != null && all != null && all.anS() != null && (aln.WQ() instanceof NoPressedRelativeLayout)) {
                BdTypeListView listView = aln.getListView();
                View anS = all.anS();
                if (listView != null) {
                    boolean z = listView.indexOfChild(anS) >= 0;
                    if (this.bmJ != null && !z && this.cUT.getTop() <= this.cyv) {
                        this.bmJ.hideTip();
                    }
                }
            }
        }
    }

    public void fA(boolean z) {
        this.cYH = z;
    }

    public void kM(int i) {
        this.cYI = i;
    }

    public void onDestroy() {
        if (this.bmJ != null) {
            this.bmJ.onDestroy();
        }
    }
}
