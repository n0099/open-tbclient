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
import com.baidu.tieba.frs.az;
import com.baidu.tieba.frs.cq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c {
    private int bIW;
    private final FrsActivity bST;
    private cq bYE;
    private TextView bYF;
    private boolean bYG;
    private int bYH = -1;

    public c(FrsActivity frsActivity) {
        this.bIW = 0;
        if (frsActivity == null) {
            throw new NullPointerException("FrsActivity is null");
        }
        this.bST = frsActivity;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bIW = UtilHelper.getStatusBarHeight();
        }
    }

    public void adi() {
        if (this.bYG && this.bYH >= 0) {
            is(this.bYH);
        }
        this.bYG = false;
    }

    public void adj() {
        if (this.bYE != null) {
            this.bYE.hideTip();
        }
    }

    public void ir(int i) {
        if (i >= 0) {
            ei(true);
            it(i);
            return;
        }
        ei(false);
        it(i);
    }

    private void is(int i) {
        String string;
        com.baidu.tieba.frs.entelechy.b.d YY = this.bST.YY();
        az Za = this.bST.Za();
        if (Za != null && YY != null && YY.abB() != null && (Za.aaf() instanceof NoPressedRelativeLayout)) {
            if (this.bYF == null) {
                this.bYF = new TextView(this.bST.getPageContext().getPageActivity());
                this.bYF.setTextSize(0, this.bST.getResources().getDimensionPixelSize(w.f.fontsize28));
                this.bYF.setGravity(17);
            }
            if (i > 0) {
                string = String.format(TbadkCoreApplication.m9getInst().getString(w.l.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.m9getInst().getString(w.l.recommend_frs_refresh_nodata);
            }
            this.bYF.setText(string);
            View abB = YY.abB();
            BdTypeListView listView = Za.getListView();
            if (abB != null && listView != null) {
                int bottom = abB.getBottom();
                aq.j(this.bYF, w.e.common_color_10260);
                aq.i(this.bYF, w.e.cp_cont_g);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, k.g(TbadkCoreApplication.m9getInst(), w.f.ds56));
                layoutParams.addRule(6);
                boolean z = Za.ZI() != null && (Za.ZI().getBottom() <= abB.getTop() || Za.ZI().getVisibility() != 0);
                if (listView.indexOfChild(abB) >= 0 && z) {
                    layoutParams.topMargin = bottom;
                    if (this.bYE == null) {
                        this.bYE = new cq();
                    }
                    this.bYE.a(this.bYF, (NoPressedRelativeLayout) Za.aaf(), layoutParams, 2000);
                }
                this.bYH = -1;
            }
        }
    }

    public void adk() {
        if (this.bYF != null && this.bYF.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d YY = this.bST.YY();
            az Za = this.bST.Za();
            if (Za != null && YY != null && YY.abB() != null && (Za.aaf() instanceof NoPressedRelativeLayout)) {
                BdTypeListView listView = Za.getListView();
                View abB = YY.abB();
                if (listView != null) {
                    boolean z = listView.indexOfChild(abB) >= 0;
                    if (this.bYF.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bYF.getLayoutParams();
                        if (z && abB.getBottom() > this.bIW) {
                            layoutParams.topMargin = abB.getBottom();
                        } else {
                            layoutParams.topMargin = this.bIW;
                        }
                        this.bYF.setLayoutParams(layoutParams);
                    }
                    if (this.bYE != null && !z && this.bYF.getTop() <= this.bIW) {
                        this.bYE.hideTip();
                    }
                }
            }
        }
    }

    public void ei(boolean z) {
        this.bYG = z;
    }

    public void it(int i) {
        this.bYH = i;
    }

    public void onDestroy() {
        if (this.bYE != null) {
            this.bYE.onDestroy();
        }
    }
}
