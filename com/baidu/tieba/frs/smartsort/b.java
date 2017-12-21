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
    private at bmN;
    private final g cOB;
    private TextView cUX;
    private boolean cYL;
    private int cYM = -1;
    private int cyz;

    public b(g gVar) {
        this.cyz = 0;
        if (gVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.cOB = gVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cyz = UtilHelper.getStatusBarHeight();
        }
    }

    public void aqp() {
        if (this.cYL && this.cYM >= 0) {
            kL(this.cYM);
        }
        this.cYL = false;
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
        com.baidu.tieba.frs.entelechy.b.d all = this.cOB.all();
        j aln = this.cOB.aln();
        if (aln != null && all != null && all.anT() != null && (aln.WQ() instanceof NoPressedRelativeLayout)) {
            if (this.cUX == null && this.cOB.getPageContext() != null) {
                this.cUX = new TextView(this.cOB.getPageContext().getPageActivity());
                this.cUX.setTextSize(0, this.cOB.getResources().getDimensionPixelSize(d.e.fontsize28));
                this.cUX.setGravity(17);
            }
            if (this.cUX != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_nodata);
                }
                this.cUX.setText(string);
            }
            View anT = all.anT();
            BdTypeListView listView = aln.getListView();
            if (anT != null && listView != null) {
                aj.j(this.cUX, d.C0095d.common_color_10260);
                aj.i(this.cUX, d.C0095d.cp_cont_g);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.f(TbadkCoreApplication.getInst(), d.e.ds56));
                layoutParams.addRule(6, d.g.frs_list_content);
                if (aln.alL() != null && aln.alL().getLayoutParams() != null) {
                    layoutParams.topMargin = aln.alL().getLayoutParams().height;
                } else {
                    layoutParams.topMargin = 0;
                }
                if (this.bmN == null) {
                    this.bmN = new at();
                }
                this.bmN.a(this.cUX, (NoPressedRelativeLayout) aln.WQ(), layoutParams, 2000);
                this.cYM = -1;
            }
        }
    }

    public void aqq() {
        if (this.cUX != null && this.cUX.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d all = this.cOB.all();
            j aln = this.cOB.aln();
            if (aln != null && all != null && all.anT() != null && (aln.WQ() instanceof NoPressedRelativeLayout)) {
                BdTypeListView listView = aln.getListView();
                View anT = all.anT();
                if (listView != null) {
                    boolean z = listView.indexOfChild(anT) >= 0;
                    if (this.bmN != null && !z && this.cUX.getTop() <= this.cyz) {
                        this.bmN.hideTip();
                    }
                }
            }
        }
    }

    public void fA(boolean z) {
        this.cYL = z;
    }

    public void kM(int i) {
        this.cYM = i;
    }

    public void onDestroy() {
        if (this.bmN != null) {
            this.bmN.onDestroy();
        }
    }
}
