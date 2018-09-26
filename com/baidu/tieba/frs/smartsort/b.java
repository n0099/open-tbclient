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
/* loaded from: classes2.dex */
public class b {
    private as bCA;
    private TextView dEy;
    private final FrsFragment dKj;
    private boolean dLF;
    private int dLG = -1;
    private int dek;

    public b(FrsFragment frsFragment) {
        this.dek = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.dKj = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dek = UtilHelper.getStatusBarHeight();
        }
    }

    public void aCh() {
        if (this.dLF && this.dLG >= 0) {
            lY(this.dLG);
        }
        this.dLF = false;
    }

    public void lX(int i) {
        if (i >= 0) {
            gJ(true);
            lZ(i);
            return;
        }
        gJ(false);
        lZ(i);
    }

    private void lY(int i) {
        FrameLayout frameLayout;
        String string;
        k awe = this.dKj.awe();
        if (awe != null && awe.getListView() != null && (frameLayout = (FrameLayout) awe.axo()) != null) {
            if (this.dEy == null && this.dKj.getPageContext() != null) {
                this.dEy = new TextView(this.dKj.getPageContext().getPageActivity());
                this.dEy.setTextSize(0, this.dKj.getResources().getDimensionPixelSize(e.C0141e.fontsize28));
                this.dEy.setGravity(17);
            }
            if (this.dEy != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(e.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(e.j.smart_frs_refresh_nodata);
                }
                this.dEy.setText(string);
            }
            al.i(this.dEy, e.d.common_color_10260);
            al.h(this.dEy, e.d.cp_cont_g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(TbadkCoreApplication.getInst(), e.C0141e.ds56));
            if (awe.awT() != null && awe.awT().getLayoutParams() != null) {
                layoutParams.topMargin = awe.awT().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bCA == null) {
                this.bCA = new as();
            }
            this.bCA.a(this.dEy, frameLayout, layoutParams, 2000);
            this.dLG = -1;
        }
    }

    public void gJ(boolean z) {
        this.dLF = z;
    }

    public void lZ(int i) {
        this.dLG = i;
    }

    public void onDestroy() {
        if (this.bCA != null) {
            this.bCA.onDestroy();
        }
    }
}
