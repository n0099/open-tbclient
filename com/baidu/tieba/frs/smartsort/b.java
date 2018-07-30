package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.k;
/* loaded from: classes2.dex */
public class b {
    private as bwJ;
    private int cYs;
    private final FrsFragment dDw;
    private boolean dEB;
    private int dEC = -1;
    private TextView dxR;

    public b(FrsFragment frsFragment) {
        this.cYs = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.dDw = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cYs = UtilHelper.getStatusBarHeight();
        }
    }

    public void aAb() {
        if (this.dEB && this.dEC >= 0) {
            lw(this.dEC);
        }
        this.dEB = false;
    }

    public void lv(int i) {
        if (i >= 0) {
            gn(true);
            lx(i);
            return;
        }
        gn(false);
        lx(i);
    }

    private void lw(int i) {
        FrameLayout frameLayout;
        String string;
        k aum = this.dDw.aum();
        if (aum != null && aum.getListView() != null && (frameLayout = (FrameLayout) aum.avv()) != null) {
            if (this.dxR == null && this.dDw.getPageContext() != null) {
                this.dxR = new TextView(this.dDw.getPageContext().getPageActivity());
                this.dxR.setTextSize(0, this.dDw.getResources().getDimensionPixelSize(d.e.fontsize28));
                this.dxR.setGravity(17);
            }
            if (this.dxR != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.j.smart_frs_refresh_nodata);
                }
                this.dxR.setText(string);
            }
            am.i(this.dxR, d.C0140d.common_color_10260);
            am.h(this.dxR, d.C0140d.cp_cont_g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.f(TbadkCoreApplication.getInst(), d.e.ds56));
            if (aum.avb() != null && aum.avb().getLayoutParams() != null) {
                layoutParams.topMargin = aum.avb().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bwJ == null) {
                this.bwJ = new as();
            }
            this.bwJ.a(this.dxR, frameLayout, layoutParams, 2000);
            this.dEC = -1;
        }
    }

    public void gn(boolean z) {
        this.dEB = z;
    }

    public void lx(int i) {
        this.dEC = i;
    }

    public void onDestroy() {
        if (this.bwJ != null) {
            this.bwJ.onDestroy();
        }
    }
}
