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
    private as bmI;
    private final com.baidu.tieba.frs.f cOm;
    private TextView cUI;
    private boolean cYv;
    private int cYw = -1;
    private int cyn;

    public b(com.baidu.tieba.frs.f fVar) {
        this.cyn = 0;
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.cOm = fVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cyn = UtilHelper.getStatusBarHeight();
        }
    }

    public void aqg() {
        if (this.cYv && this.cYw >= 0) {
            kJ(this.cYw);
        }
        this.cYv = false;
    }

    public void kI(int i) {
        if (i >= 0) {
            fz(true);
            kK(i);
            return;
        }
        fz(false);
        kK(i);
    }

    private void kJ(int i) {
        String string;
        com.baidu.tieba.frs.entelechy.b.d alc = this.cOm.alc();
        i ale = this.cOm.ale();
        if (ale != null && alc != null && alc.anK() != null && (ale.WP() instanceof NoPressedRelativeLayout)) {
            if (this.cUI == null && this.cOm.getPageContext() != null) {
                this.cUI = new TextView(this.cOm.getPageContext().getPageActivity());
                this.cUI.setTextSize(0, this.cOm.getResources().getDimensionPixelSize(d.e.fontsize28));
                this.cUI.setGravity(17);
            }
            if (this.cUI != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_nodata);
                }
                this.cUI.setText(string);
            }
            View anK = alc.anK();
            BdTypeListView listView = ale.getListView();
            if (anK != null && listView != null) {
                aj.j(this.cUI, d.C0082d.common_color_10260);
                aj.i(this.cUI, d.C0082d.cp_cont_g);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.f(TbadkCoreApplication.getInst(), d.e.ds56));
                layoutParams.addRule(6, d.g.frs_list_content);
                if (ale.alC() != null && ale.alC().getLayoutParams() != null) {
                    layoutParams.topMargin = ale.alC().getLayoutParams().height;
                } else {
                    layoutParams.topMargin = 0;
                }
                if (this.bmI == null) {
                    this.bmI = new as();
                }
                this.bmI.a(this.cUI, (NoPressedRelativeLayout) ale.WP(), layoutParams, 2000);
                this.cYw = -1;
            }
        }
    }

    public void aqh() {
        if (this.cUI != null && this.cUI.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d alc = this.cOm.alc();
            i ale = this.cOm.ale();
            if (ale != null && alc != null && alc.anK() != null && (ale.WP() instanceof NoPressedRelativeLayout)) {
                BdTypeListView listView = ale.getListView();
                View anK = alc.anK();
                if (listView != null) {
                    boolean z = listView.indexOfChild(anK) >= 0;
                    if (this.bmI != null && !z && this.cUI.getTop() <= this.cyn) {
                        this.bmI.hideTip();
                    }
                }
            }
        }
    }

    public void fz(boolean z) {
        this.cYv = z;
    }

    public void kK(int i) {
        this.cYw = i;
    }

    public void onDestroy() {
        if (this.bmI != null) {
            this.bmI.onDestroy();
        }
    }
}
