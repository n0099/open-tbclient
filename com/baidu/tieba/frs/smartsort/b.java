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
    private ar bdF;
    private int ccu;
    private final com.baidu.tieba.frs.f cna;
    private TextView csR;
    private boolean cud;
    private int cue = -1;

    public b(com.baidu.tieba.frs.f fVar) {
        this.ccu = 0;
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.cna = fVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.ccu = UtilHelper.getStatusBarHeight();
        }
    }

    public void aiG() {
        if (this.cud && this.cue >= 0) {
            ji(this.cue);
        }
        this.cud = false;
    }

    public void jh(int i) {
        if (i >= 0) {
            eZ(true);
            jj(i);
            return;
        }
        eZ(false);
        jj(i);
    }

    private void ji(int i) {
        String string;
        com.baidu.tieba.frs.entelechy.b.d aeS = this.cna.aeS();
        i aeU = this.cna.aeU();
        if (aeU != null && aeS != null && aeS.agU() != null && (aeU.VM() instanceof NoPressedRelativeLayout)) {
            if (this.csR == null && this.cna.getPageContext() != null) {
                this.csR = new TextView(this.cna.getPageContext().getPageActivity());
                this.csR.setTextSize(0, this.cna.getResources().getDimensionPixelSize(d.f.fontsize28));
                this.csR.setGravity(17);
            }
            if (this.csR != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_nodata);
                }
                this.csR.setText(string);
            }
            View agU = aeS.agU();
            BdTypeListView listView = aeU.getListView();
            if (agU != null && listView != null) {
                ai.j(this.csR, d.e.common_color_10260);
                ai.i(this.csR, d.e.cp_cont_g);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, k.g(TbadkCoreApplication.getInst(), d.f.ds56));
                layoutParams.addRule(6, d.h.frs_list_content);
                if (aeU.aft() != null && aeU.aft().getLayoutParams() != null) {
                    layoutParams.topMargin = aeU.aft().getLayoutParams().height;
                } else {
                    layoutParams.topMargin = 0;
                }
                if (this.bdF == null) {
                    this.bdF = new ar();
                }
                this.bdF.a(this.csR, (NoPressedRelativeLayout) aeU.VM(), layoutParams, 2000);
                this.cue = -1;
            }
        }
    }

    public void aiH() {
        if (this.csR != null && this.csR.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d aeS = this.cna.aeS();
            i aeU = this.cna.aeU();
            if (aeU != null && aeS != null && aeS.agU() != null && (aeU.VM() instanceof NoPressedRelativeLayout)) {
                BdTypeListView listView = aeU.getListView();
                View agU = aeS.agU();
                if (listView != null) {
                    boolean z = listView.indexOfChild(agU) >= 0;
                    if (this.bdF != null && !z && this.csR.getTop() <= this.ccu) {
                        this.bdF.hideTip();
                    }
                }
            }
        }
    }

    public void eZ(boolean z) {
        this.cud = z;
    }

    public void jj(int i) {
        this.cue = i;
    }

    public void onDestroy() {
        if (this.bdF != null) {
            this.bdF.onDestroy();
        }
    }
}
