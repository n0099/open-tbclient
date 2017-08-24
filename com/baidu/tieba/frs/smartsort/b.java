package com.baidu.tieba.frs.smartsort;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.i;
/* loaded from: classes.dex */
public class b {
    private ar beR;
    private int cen;
    private final com.baidu.tieba.frs.f coV;
    private TextView cwp;
    private boolean cxy;
    private int cxz = -1;

    public b(com.baidu.tieba.frs.f fVar) {
        this.cen = 0;
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.coV = fVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cen = UtilHelper.getStatusBarHeight();
        }
    }

    public void ajt() {
        if (this.cxy && this.cxz >= 0) {
            js(this.cxz);
        }
        this.cxy = false;
    }

    public void jr(int i) {
        if (i >= 0) {
            fc(true);
            jt(i);
            return;
        }
        fc(false);
        jt(i);
    }

    private void js(int i) {
        String string;
        com.baidu.tieba.frs.entelechy.b.d afn = this.coV.afn();
        i afp = this.coV.afp();
        if (afp != null && afn != null && afn.ahq() != null && (afp.Wk() instanceof NoPressedRelativeLayout)) {
            if (this.cwp == null && this.coV.getPageContext() != null) {
                this.cwp = new TextView(this.coV.getPageContext().getPageActivity());
                this.cwp.setTextSize(0, this.coV.getResources().getDimensionPixelSize(d.f.fontsize28));
                this.cwp.setGravity(17);
            }
            if (this.cwp != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_nodata);
                }
                this.cwp.setText(string);
            }
            View ahq = afn.ahq();
            BdTypeListView listView = afp.getListView();
            if (ahq != null && listView != null) {
                ai.j(this.cwp, d.e.common_color_10260);
                ai.i(this.cwp, d.e.cp_cont_g);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, k.g(TbadkCoreApplication.getInst(), d.f.ds56));
                layoutParams.addRule(6, d.h.frs_list_content);
                if (afp.afP() != null && afp.afP().getLayoutParams() != null) {
                    layoutParams.topMargin = afp.afP().getLayoutParams().height;
                } else {
                    layoutParams.topMargin = 0;
                }
                if (this.beR == null) {
                    this.beR = new ar();
                }
                this.beR.a(this.cwp, (NoPressedRelativeLayout) afp.Wk(), layoutParams, 2000);
                this.cxz = -1;
            }
        }
    }

    public void aju() {
        if (this.cwp != null && this.cwp.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d afn = this.coV.afn();
            i afp = this.coV.afp();
            if (afp != null && afn != null && afn.ahq() != null && (afp.Wk() instanceof NoPressedRelativeLayout)) {
                BdTypeListView listView = afp.getListView();
                View ahq = afn.ahq();
                if (listView != null) {
                    boolean z = listView.indexOfChild(ahq) >= 0;
                    if (this.beR != null && !z && this.cwp.getTop() <= this.cen) {
                        this.beR.hideTip();
                    }
                }
            }
        }
    }

    public void fc(boolean z) {
        this.cxy = z;
    }

    public void jt(int i) {
        this.cxz = i;
    }

    public void onDestroy() {
        if (this.beR != null) {
            this.beR.onDestroy();
        }
    }
}
