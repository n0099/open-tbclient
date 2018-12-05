package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.k;
/* loaded from: classes6.dex */
public class b {
    private as bPF;
    private TextView dUe;
    private final FrsFragment dZP;
    private int dtW;
    private boolean ebk;
    private int ebl = -1;

    public b(FrsFragment frsFragment) {
        this.dtW = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.dZP = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dtW = UtilHelper.getStatusBarHeight();
        }
    }

    public void aGI() {
        if (this.ebk && this.ebl >= 0) {
            ne(this.ebl);
        }
        this.ebk = false;
    }

    public void nd(int i) {
        if (i >= 0) {
            hn(true);
            nf(i);
            return;
        }
        hn(false);
        nf(i);
    }

    private void ne(int i) {
        FrameLayout frameLayout;
        String string;
        k aAI = this.dZP.aAI();
        if (aAI != null && aAI.getListView() != null && (frameLayout = (FrameLayout) aAI.aBR()) != null) {
            if (this.dUe == null && this.dZP.getPageContext() != null) {
                this.dUe = new TextView(this.dZP.getPageContext().getPageActivity());
                this.dUe.setTextSize(0, this.dZP.getResources().getDimensionPixelSize(e.C0210e.fontsize28));
                this.dUe.setGravity(17);
            }
            if (this.dUe != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(e.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(e.j.smart_frs_refresh_nodata);
                }
                this.dUe.setText(string);
            }
            al.i(this.dUe, e.d.common_color_10260);
            al.h(this.dUe, e.d.cp_cont_g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(TbadkCoreApplication.getInst(), e.C0210e.ds56));
            if (aAI.aBw() != null && aAI.aBw().getLayoutParams() != null) {
                layoutParams.topMargin = aAI.aBw().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bPF == null) {
                this.bPF = new as();
            }
            this.bPF.a(this.dUe, frameLayout, layoutParams, 2000);
            this.ebl = -1;
        }
    }

    public void hn(boolean z) {
        this.ebk = z;
    }

    public void nf(int i) {
        this.ebl = i;
    }

    public void onDestroy() {
        if (this.bPF != null) {
            this.bPF.onDestroy();
        }
    }
}
