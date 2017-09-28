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
    private as bgz;
    private TextView cEv;
    private boolean cFL;
    private int cFM = -1;
    private int chZ;
    private final com.baidu.tieba.frs.f cxi;

    public b(com.baidu.tieba.frs.f fVar) {
        this.chZ = 0;
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.cxi = fVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.chZ = UtilHelper.getStatusBarHeight();
        }
    }

    public void alr() {
        if (this.cFL && this.cFM >= 0) {
            jQ(this.cFM);
        }
        this.cFL = false;
    }

    public void jP(int i) {
        if (i >= 0) {
            ff(true);
            jR(i);
            return;
        }
        ff(false);
        jR(i);
    }

    private void jQ(int i) {
        String string;
        com.baidu.tieba.frs.entelechy.b.d agS = this.cxi.agS();
        i agU = this.cxi.agU();
        if (agU != null && agS != null && agS.ajt() != null && (agU.ahL() instanceof NoPressedRelativeLayout)) {
            if (this.cEv == null && this.cxi.getPageContext() != null) {
                this.cEv = new TextView(this.cxi.getPageContext().getPageActivity());
                this.cEv.setTextSize(0, this.cxi.getResources().getDimensionPixelSize(d.f.fontsize28));
                this.cEv.setGravity(17);
            }
            if (this.cEv != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_nodata);
                }
                this.cEv.setText(string);
            }
            View ajt = agS.ajt();
            BdTypeListView listView = agU.getListView();
            if (ajt != null && listView != null) {
                aj.j(this.cEv, d.e.common_color_10260);
                aj.i(this.cEv, d.e.cp_cont_g);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.f(TbadkCoreApplication.getInst(), d.f.ds56));
                layoutParams.addRule(6, d.h.frs_list_content);
                if (agU.ahr() != null && agU.ahr().getLayoutParams() != null) {
                    layoutParams.topMargin = agU.ahr().getLayoutParams().height;
                } else {
                    layoutParams.topMargin = 0;
                }
                if (this.bgz == null) {
                    this.bgz = new as();
                }
                this.bgz.a(this.cEv, (NoPressedRelativeLayout) agU.ahL(), layoutParams, 2000);
                this.cFM = -1;
            }
        }
    }

    public void als() {
        if (this.cEv != null && this.cEv.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d agS = this.cxi.agS();
            i agU = this.cxi.agU();
            if (agU != null && agS != null && agS.ajt() != null && (agU.ahL() instanceof NoPressedRelativeLayout)) {
                BdTypeListView listView = agU.getListView();
                View ajt = agS.ajt();
                if (listView != null) {
                    boolean z = listView.indexOfChild(ajt) >= 0;
                    if (this.bgz != null && !z && this.cEv.getTop() <= this.chZ) {
                        this.bgz.hideTip();
                    }
                }
            }
        }
    }

    public void ff(boolean z) {
        this.cFL = z;
    }

    public void jR(int i) {
        this.cFM = i;
    }

    public void onDestroy() {
        if (this.bgz != null) {
            this.bgz.onDestroy();
        }
    }
}
