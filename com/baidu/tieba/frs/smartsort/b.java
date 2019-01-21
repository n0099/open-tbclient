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
    private as bQu;
    private TextView dXC;
    private int dxu;
    private final FrsFragment edn;
    private boolean eeI;
    private int eeJ = -1;

    public b(FrsFragment frsFragment) {
        this.dxu = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.edn = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dxu = UtilHelper.getStatusBarHeight();
        }
    }

    public void aHU() {
        if (this.eeI && this.eeJ >= 0) {
            ns(this.eeJ);
        }
        this.eeI = false;
    }

    public void nr(int i) {
        if (i >= 0) {
            ht(true);
            nt(i);
            return;
        }
        ht(false);
        nt(i);
    }

    private void ns(int i) {
        FrameLayout frameLayout;
        String string;
        k aBU = this.edn.aBU();
        if (aBU != null && aBU.getListView() != null && (frameLayout = (FrameLayout) aBU.aDd()) != null) {
            if (this.dXC == null && this.edn.getPageContext() != null) {
                this.dXC = new TextView(this.edn.getPageContext().getPageActivity());
                this.dXC.setTextSize(0, this.edn.getResources().getDimensionPixelSize(e.C0210e.fontsize28));
                this.dXC.setGravity(17);
            }
            if (this.dXC != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(e.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(e.j.smart_frs_refresh_nodata);
                }
                this.dXC.setText(string);
            }
            al.i(this.dXC, e.d.common_color_10260);
            al.h(this.dXC, e.d.cp_cont_g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(TbadkCoreApplication.getInst(), e.C0210e.ds56));
            if (aBU.aCI() != null && aBU.aCI().getLayoutParams() != null) {
                layoutParams.topMargin = aBU.aCI().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bQu == null) {
                this.bQu = new as();
            }
            this.bQu.a(this.dXC, frameLayout, layoutParams, 2000);
            this.eeJ = -1;
        }
    }

    public void ht(boolean z) {
        this.eeI = z;
    }

    public void nt(int i) {
        this.eeJ = i;
    }

    public void onDestroy() {
        if (this.bQu != null) {
            this.bQu.onDestroy();
        }
    }
}
