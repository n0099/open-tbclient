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
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.ch;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c {
    private int bKr;
    private final r bNK;
    private ch bYJ;
    private TextView bYK;
    private boolean bYL;
    private int bYM = -1;

    public c(r rVar) {
        this.bKr = 0;
        if (rVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.bNK = rVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bKr = UtilHelper.getStatusBarHeight();
        }
    }

    public void acm() {
        if (this.bYL && this.bYM >= 0) {
            ip(this.bYM);
        }
        this.bYL = false;
    }

    public void io(int i) {
        if (i >= 0) {
            eg(true);
            iq(i);
            return;
        }
        eg(false);
        iq(i);
    }

    private void ip(int i) {
        String string;
        com.baidu.tieba.frs.entelechy.b.d YX = this.bNK.YX();
        at YZ = this.bNK.YZ();
        if (YZ != null && YX != null && YX.aaP() != null && (YZ.ZP() instanceof NoPressedRelativeLayout)) {
            if (this.bYK == null && this.bNK.getPageContext() != null) {
                this.bYK = new TextView(this.bNK.getPageContext().getPageActivity());
                this.bYK.setTextSize(0, this.bNK.getResources().getDimensionPixelSize(w.f.fontsize28));
                this.bYK.setGravity(17);
            }
            if (this.bYK != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.m9getInst().getString(w.l.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.m9getInst().getString(w.l.recommend_frs_refresh_nodata);
                }
                this.bYK.setText(string);
            }
            View aaP = YX.aaP();
            BdTypeListView listView = YZ.getListView();
            if (aaP != null && listView != null) {
                aq.j(this.bYK, w.e.common_color_10260);
                aq.i(this.bYK, w.e.cp_cont_g);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, k.g(TbadkCoreApplication.m9getInst(), w.f.ds56));
                layoutParams.addRule(6, w.h.frs_list_content);
                if (YZ.Zy() != null && YZ.Zy().getLayoutParams() != null) {
                    layoutParams.topMargin = YZ.Zy().getLayoutParams().height;
                } else {
                    layoutParams.topMargin = 0;
                }
                if (this.bYJ == null) {
                    this.bYJ = new ch();
                }
                this.bYJ.a(this.bYK, (NoPressedRelativeLayout) YZ.ZP(), layoutParams, 2000);
                this.bYM = -1;
            }
        }
    }

    public void acn() {
        if (this.bYK != null && this.bYK.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d YX = this.bNK.YX();
            at YZ = this.bNK.YZ();
            if (YZ != null && YX != null && YX.aaP() != null && (YZ.ZP() instanceof NoPressedRelativeLayout)) {
                BdTypeListView listView = YZ.getListView();
                View aaP = YX.aaP();
                if (listView != null) {
                    boolean z = listView.indexOfChild(aaP) >= 0;
                    if (this.bYJ != null && !z && this.bYK.getTop() <= this.bKr) {
                        this.bYJ.hideTip();
                    }
                }
            }
        }
    }

    public void eg(boolean z) {
        this.bYL = z;
    }

    public void iq(int i) {
        this.bYM = i;
    }

    public void onDestroy() {
        if (this.bYJ != null) {
            this.bYJ.onDestroy();
        }
    }
}
