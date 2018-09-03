package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.k;
/* loaded from: classes2.dex */
public class b {
    private as bwL;
    private int cYo;
    private final FrsFragment dDt;
    private boolean dEy;
    private int dEz = -1;
    private TextView dxO;

    public b(FrsFragment frsFragment) {
        this.cYo = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.dDt = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cYo = UtilHelper.getStatusBarHeight();
        }
    }

    public void azY() {
        if (this.dEy && this.dEz >= 0) {
            lw(this.dEz);
        }
        this.dEy = false;
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
        k aul = this.dDt.aul();
        if (aul != null && aul.getListView() != null && (frameLayout = (FrameLayout) aul.avu()) != null) {
            if (this.dxO == null && this.dDt.getPageContext() != null) {
                this.dxO = new TextView(this.dDt.getPageContext().getPageActivity());
                this.dxO.setTextSize(0, this.dDt.getResources().getDimensionPixelSize(f.e.fontsize28));
                this.dxO.setGravity(17);
            }
            if (this.dxO != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(f.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(f.j.smart_frs_refresh_nodata);
                }
                this.dxO.setText(string);
            }
            am.i(this.dxO, f.d.common_color_10260);
            am.h(this.dxO, f.d.cp_cont_g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.f(TbadkCoreApplication.getInst(), f.e.ds56));
            if (aul.ava() != null && aul.ava().getLayoutParams() != null) {
                layoutParams.topMargin = aul.ava().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bwL == null) {
                this.bwL = new as();
            }
            this.bwL.a(this.dxO, frameLayout, layoutParams, 2000);
            this.dEz = -1;
        }
    }

    public void gn(boolean z) {
        this.dEy = z;
    }

    public void lx(int i) {
        this.dEz = i;
    }

    public void onDestroy() {
        if (this.bwL != null) {
            this.bwL.onDestroy();
        }
    }
}
