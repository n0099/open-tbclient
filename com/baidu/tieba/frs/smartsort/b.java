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
    private as bhk;
    private final com.baidu.tieba.frs.f cFg;
    private TextView cLu;
    private boolean cPg;
    private int cPh = -1;
    private int cpC;

    public b(com.baidu.tieba.frs.f fVar) {
        this.cpC = 0;
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.cFg = fVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cpC = UtilHelper.getStatusBarHeight();
        }
    }

    public void aom() {
        if (this.cPg && this.cPh >= 0) {
            kl(this.cPh);
        }
        this.cPg = false;
    }

    public void kk(int i) {
        if (i >= 0) {
            fi(true);
            km(i);
            return;
        }
        fi(false);
        km(i);
    }

    private void kl(int i) {
        String string;
        com.baidu.tieba.frs.entelechy.b.d aji = this.cFg.aji();
        i ajk = this.cFg.ajk();
        if (ajk != null && aji != null && aji.alP() != null && (ajk.VB() instanceof NoPressedRelativeLayout)) {
            if (this.cLu == null && this.cFg.getPageContext() != null) {
                this.cLu = new TextView(this.cFg.getPageContext().getPageActivity());
                this.cLu.setTextSize(0, this.cFg.getResources().getDimensionPixelSize(d.e.fontsize28));
                this.cLu.setGravity(17);
            }
            if (this.cLu != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_nodata);
                }
                this.cLu.setText(string);
            }
            View alP = aji.alP();
            BdTypeListView listView = ajk.getListView();
            if (alP != null && listView != null) {
                aj.j(this.cLu, d.C0080d.common_color_10260);
                aj.i(this.cLu, d.C0080d.cp_cont_g);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.f(TbadkCoreApplication.getInst(), d.e.ds56));
                layoutParams.addRule(6, d.g.frs_list_content);
                if (ajk.ajI() != null && ajk.ajI().getLayoutParams() != null) {
                    layoutParams.topMargin = ajk.ajI().getLayoutParams().height;
                } else {
                    layoutParams.topMargin = 0;
                }
                if (this.bhk == null) {
                    this.bhk = new as();
                }
                this.bhk.a(this.cLu, (NoPressedRelativeLayout) ajk.VB(), layoutParams, 2000);
                this.cPh = -1;
            }
        }
    }

    public void aon() {
        if (this.cLu != null && this.cLu.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d aji = this.cFg.aji();
            i ajk = this.cFg.ajk();
            if (ajk != null && aji != null && aji.alP() != null && (ajk.VB() instanceof NoPressedRelativeLayout)) {
                BdTypeListView listView = ajk.getListView();
                View alP = aji.alP();
                if (listView != null) {
                    boolean z = listView.indexOfChild(alP) >= 0;
                    if (this.bhk != null && !z && this.cLu.getTop() <= this.cpC) {
                        this.bhk.hideTip();
                    }
                }
            }
        }
    }

    public void fi(boolean z) {
        this.cPg = z;
    }

    public void km(int i) {
        this.cPh = i;
    }

    public void onDestroy() {
        if (this.bhk != null) {
            this.bhk.onDestroy();
        }
    }
}
