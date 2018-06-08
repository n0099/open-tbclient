package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.i;
/* loaded from: classes2.dex */
public class b {
    private aq buI;
    private int cXA;
    private TextView drV;
    private final FrsFragment dxw;
    private boolean dyA;
    private int dyB = -1;

    public b(FrsFragment frsFragment) {
        this.cXA = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.dxw = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cXA = UtilHelper.getStatusBarHeight();
        }
    }

    public void ayO() {
        if (this.dyA && this.dyB >= 0) {
            le(this.dyB);
        }
        this.dyA = false;
    }

    public void ld(int i) {
        if (i >= 0) {
            gb(true);
            lf(i);
            return;
        }
        gb(false);
        lf(i);
    }

    private void le(int i) {
        FrameLayout frameLayout;
        String string;
        i atr = this.dxw.atr();
        if (atr != null && atr.getListView() != null && (frameLayout = (FrameLayout) atr.auy()) != null) {
            if (this.drV == null && this.dxw.getPageContext() != null) {
                this.drV = new TextView(this.dxw.getPageContext().getPageActivity());
                this.drV.setTextSize(0, this.dxw.getResources().getDimensionPixelSize(d.e.fontsize28));
                this.drV.setGravity(17);
            }
            if (this.drV != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.k.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.k.smart_frs_refresh_nodata);
                }
                this.drV.setText(string);
            }
            al.i(this.drV, d.C0141d.common_color_10260);
            al.h(this.drV, d.C0141d.cp_cont_g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.e(TbadkCoreApplication.getInst(), d.e.ds56));
            if (atr.auf() != null && atr.auf().getLayoutParams() != null) {
                layoutParams.topMargin = atr.auf().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.buI == null) {
                this.buI = new aq();
            }
            this.buI.a(this.drV, frameLayout, layoutParams, 2000);
            this.dyB = -1;
        }
    }

    public void gb(boolean z) {
        this.dyA = z;
    }

    public void lf(int i) {
        this.dyB = i;
    }

    public void onDestroy() {
        if (this.buI != null) {
            this.buI.onDestroy();
        }
    }
}
