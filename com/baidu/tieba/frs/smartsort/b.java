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
    private as bLQ;
    private TextView dNB;
    private final FrsFragment dTm;
    private boolean dUH;
    private int dUI = -1;
    private int dnv;

    public b(FrsFragment frsFragment) {
        this.dnv = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.dTm = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dnv = UtilHelper.getStatusBarHeight();
        }
    }

    public void aEW() {
        if (this.dUH && this.dUI >= 0) {
            mO(this.dUI);
        }
        this.dUH = false;
    }

    public void mN(int i) {
        if (i >= 0) {
            hl(true);
            mP(i);
            return;
        }
        hl(false);
        mP(i);
    }

    private void mO(int i) {
        FrameLayout frameLayout;
        String string;
        k ayY = this.dTm.ayY();
        if (ayY != null && ayY.getListView() != null && (frameLayout = (FrameLayout) ayY.aAh()) != null) {
            if (this.dNB == null && this.dTm.getPageContext() != null) {
                this.dNB = new TextView(this.dTm.getPageContext().getPageActivity());
                this.dNB.setTextSize(0, this.dTm.getResources().getDimensionPixelSize(e.C0200e.fontsize28));
                this.dNB.setGravity(17);
            }
            if (this.dNB != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(e.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(e.j.smart_frs_refresh_nodata);
                }
                this.dNB.setText(string);
            }
            al.i(this.dNB, e.d.common_color_10260);
            al.h(this.dNB, e.d.cp_cont_g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(TbadkCoreApplication.getInst(), e.C0200e.ds56));
            if (ayY.azM() != null && ayY.azM().getLayoutParams() != null) {
                layoutParams.topMargin = ayY.azM().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bLQ == null) {
                this.bLQ = new as();
            }
            this.bLQ.a(this.dNB, frameLayout, layoutParams, 2000);
            this.dUI = -1;
        }
    }

    public void hl(boolean z) {
        this.dUH = z;
    }

    public void mP(int i) {
        this.dUI = i;
    }

    public void onDestroy() {
        if (this.bLQ != null) {
            this.bLQ.onDestroy();
        }
    }
}
