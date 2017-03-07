package com.baidu.tieba.frs.smartsort;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.co;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c {
    private int bJd;
    private final FrsActivity bTf;
    private co cad;
    private TextView cae;
    private boolean caf;
    private int cag = -1;

    public c(FrsActivity frsActivity) {
        this.bJd = 0;
        if (frsActivity == null) {
            throw new NullPointerException("FrsActivity is null");
        }
        this.bTf = frsActivity;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bJd = UtilHelper.getStatusBarHeight();
        }
    }

    public void ado() {
        if (this.caf && this.cag >= 0) {
            ir(this.cag);
        }
        this.caf = false;
    }

    public void adp() {
        if (this.cad != null) {
            this.cad.hideTip();
        }
    }

    public void iq(int i) {
        if (i >= 0) {
            ei(true);
            is(i);
            return;
        }
        ei(false);
        is(i);
    }

    private void ir(int i) {
        String string;
        com.baidu.tieba.frs.entelechy.b.d YC = this.bTf.YC();
        ax YE = this.bTf.YE();
        if (YE != null && YC != null && YC.abe() != null && (YE.ZH() instanceof NoPressedRelativeLayout)) {
            if (this.cae == null) {
                this.cae = new TextView(this.bTf.getPageContext().getPageActivity());
                this.cae.setTextSize(0, this.bTf.getResources().getDimensionPixelSize(w.f.fontsize28));
                this.cae.setGravity(17);
            }
            if (i > 0) {
                string = String.format(TbadkCoreApplication.m9getInst().getString(w.l.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.m9getInst().getString(w.l.recommend_frs_refresh_nodata);
            }
            this.cae.setText(string);
            View abe = YC.abe();
            BdTypeListView listView = YE.getListView();
            if (abe != null && listView != null) {
                int bottom = abe.getBottom();
                aq.j(this.cae, w.e.common_color_10260);
                aq.i((View) this.cae, w.e.cp_cont_g);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, k.g(TbadkCoreApplication.m9getInst(), w.f.ds56));
                layoutParams.addRule(6);
                boolean z = YE.Zk() != null && (YE.Zk().getBottom() <= abe.getTop() || YE.Zk().getVisibility() != 0);
                if (listView.indexOfChild(abe) >= 0 && z) {
                    layoutParams.topMargin = bottom;
                    if (this.cad == null) {
                        this.cad = new co();
                    }
                    this.cad.a(this.cae, (NoPressedRelativeLayout) YE.ZH(), layoutParams, 2000);
                }
                this.cag = -1;
            }
        }
    }

    public void adq() {
        if (this.cae != null && this.cae.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d YC = this.bTf.YC();
            ax YE = this.bTf.YE();
            if (YE != null && YC != null && YC.abe() != null && (YE.ZH() instanceof NoPressedRelativeLayout)) {
                BdTypeListView listView = YE.getListView();
                View abe = YC.abe();
                if (listView != null) {
                    boolean z = listView.indexOfChild(abe) >= 0;
                    if (this.cae.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cae.getLayoutParams();
                        if (z && abe.getBottom() > this.bJd) {
                            layoutParams.topMargin = abe.getBottom();
                        } else {
                            layoutParams.topMargin = this.bJd;
                        }
                        this.cae.setLayoutParams(layoutParams);
                    }
                    if (this.cad != null && !z && this.cae.getTop() <= this.bJd) {
                        this.cad.hideTip();
                    }
                }
            }
        }
    }

    public void ei(boolean z) {
        this.caf = z;
    }

    public void is(int i) {
        this.cag = i;
    }

    public void onDestroy() {
        if (this.cad != null) {
            this.cad.onDestroy();
        }
    }
}
