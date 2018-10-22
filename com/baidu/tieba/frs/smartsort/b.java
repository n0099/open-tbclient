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
    private as bLf;
    private TextView dMx;
    private final FrsFragment dSg;
    private boolean dTB;
    private int dTC = -1;
    private int dmq;

    public b(FrsFragment frsFragment) {
        this.dmq = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.dSg = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dmq = UtilHelper.getStatusBarHeight();
        }
    }

    public void aFA() {
        if (this.dTB && this.dTC >= 0) {
            mw(this.dTC);
        }
        this.dTB = false;
    }

    public void mv(int i) {
        if (i >= 0) {
            hb(true);
            mx(i);
            return;
        }
        hb(false);
        mx(i);
    }

    private void mw(int i) {
        FrameLayout frameLayout;
        String string;
        k azB = this.dSg.azB();
        if (azB != null && azB.getListView() != null && (frameLayout = (FrameLayout) azB.aAK()) != null) {
            if (this.dMx == null && this.dSg.getPageContext() != null) {
                this.dMx = new TextView(this.dSg.getPageContext().getPageActivity());
                this.dMx.setTextSize(0, this.dSg.getResources().getDimensionPixelSize(e.C0175e.fontsize28));
                this.dMx.setGravity(17);
            }
            if (this.dMx != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(e.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(e.j.smart_frs_refresh_nodata);
                }
                this.dMx.setText(string);
            }
            al.i(this.dMx, e.d.common_color_10260);
            al.h(this.dMx, e.d.cp_cont_g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(TbadkCoreApplication.getInst(), e.C0175e.ds56));
            if (azB.aAp() != null && azB.aAp().getLayoutParams() != null) {
                layoutParams.topMargin = azB.aAp().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bLf == null) {
                this.bLf = new as();
            }
            this.bLf.a(this.dMx, frameLayout, layoutParams, 2000);
            this.dTC = -1;
        }
    }

    public void hb(boolean z) {
        this.dTB = z;
    }

    public void mx(int i) {
        this.dTC = i;
    }

    public void onDestroy() {
        if (this.bLf != null) {
            this.bLf.onDestroy();
        }
    }
}
