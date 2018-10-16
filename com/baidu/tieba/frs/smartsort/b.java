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
    private final FrsFragment dSf;
    private boolean dTA;
    private int dTB = -1;
    private int dmq;

    public b(FrsFragment frsFragment) {
        this.dmq = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.dSf = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dmq = UtilHelper.getStatusBarHeight();
        }
    }

    public void aFA() {
        if (this.dTA && this.dTB >= 0) {
            mw(this.dTB);
        }
        this.dTA = false;
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
        k azA = this.dSf.azA();
        if (azA != null && azA.getListView() != null && (frameLayout = (FrameLayout) azA.aAJ()) != null) {
            if (this.dMx == null && this.dSf.getPageContext() != null) {
                this.dMx = new TextView(this.dSf.getPageContext().getPageActivity());
                this.dMx.setTextSize(0, this.dSf.getResources().getDimensionPixelSize(e.C0175e.fontsize28));
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
            if (azA.aAo() != null && azA.aAo().getLayoutParams() != null) {
                layoutParams.topMargin = azA.aAo().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bLf == null) {
                this.bLf = new as();
            }
            this.bLf.a(this.dMx, frameLayout, layoutParams, 2000);
            this.dTB = -1;
        }
    }

    public void hb(boolean z) {
        this.dTA = z;
    }

    public void mx(int i) {
        this.dTB = i;
    }

    public void onDestroy() {
        if (this.bLf != null) {
            this.bLf.onDestroy();
        }
    }
}
