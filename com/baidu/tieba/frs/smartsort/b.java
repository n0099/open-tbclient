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
    private as bhb;
    private final com.baidu.tieba.frs.f cEN;
    private TextView cLb;
    private boolean cOM;
    private int cON = -1;
    private int cpi;

    public b(com.baidu.tieba.frs.f fVar) {
        this.cpi = 0;
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.cEN = fVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cpi = UtilHelper.getStatusBarHeight();
        }
    }

    public void anX() {
        if (this.cOM && this.cON >= 0) {
            kl(this.cON);
        }
        this.cOM = false;
    }

    public void kk(int i) {
        if (i >= 0) {
            fd(true);
            km(i);
            return;
        }
        fd(false);
        km(i);
    }

    private void kl(int i) {
        String string;
        com.baidu.tieba.frs.entelechy.b.d aiU = this.cEN.aiU();
        i aiW = this.cEN.aiW();
        if (aiW != null && aiU != null && aiU.alB() != null && (aiW.Vq() instanceof NoPressedRelativeLayout)) {
            if (this.cLb == null && this.cEN.getPageContext() != null) {
                this.cLb = new TextView(this.cEN.getPageContext().getPageActivity());
                this.cLb.setTextSize(0, this.cEN.getResources().getDimensionPixelSize(d.e.fontsize28));
                this.cLb.setGravity(17);
            }
            if (this.cLb != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_nodata);
                }
                this.cLb.setText(string);
            }
            View alB = aiU.alB();
            BdTypeListView listView = aiW.getListView();
            if (alB != null && listView != null) {
                aj.j(this.cLb, d.C0080d.common_color_10260);
                aj.i(this.cLb, d.C0080d.cp_cont_g);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.f(TbadkCoreApplication.getInst(), d.e.ds56));
                layoutParams.addRule(6, d.g.frs_list_content);
                if (aiW.aju() != null && aiW.aju().getLayoutParams() != null) {
                    layoutParams.topMargin = aiW.aju().getLayoutParams().height;
                } else {
                    layoutParams.topMargin = 0;
                }
                if (this.bhb == null) {
                    this.bhb = new as();
                }
                this.bhb.a(this.cLb, (NoPressedRelativeLayout) aiW.Vq(), layoutParams, 2000);
                this.cON = -1;
            }
        }
    }

    public void anY() {
        if (this.cLb != null && this.cLb.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d aiU = this.cEN.aiU();
            i aiW = this.cEN.aiW();
            if (aiW != null && aiU != null && aiU.alB() != null && (aiW.Vq() instanceof NoPressedRelativeLayout)) {
                BdTypeListView listView = aiW.getListView();
                View alB = aiU.alB();
                if (listView != null) {
                    boolean z = listView.indexOfChild(alB) >= 0;
                    if (this.bhb != null && !z && this.cLb.getTop() <= this.cpi) {
                        this.bhb.hideTip();
                    }
                }
            }
        }
    }

    public void fd(boolean z) {
        this.cOM = z;
    }

    public void km(int i) {
        this.cON = i;
    }

    public void onDestroy() {
        if (this.bhb != null) {
            this.bhb.onDestroy();
        }
    }
}
