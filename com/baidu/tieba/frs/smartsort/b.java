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
    private as bQt;
    private TextView dXB;
    private int dxt;
    private final FrsFragment edm;
    private boolean eeH;
    private int eeI = -1;

    public b(FrsFragment frsFragment) {
        this.dxt = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.edm = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dxt = UtilHelper.getStatusBarHeight();
        }
    }

    public void aHU() {
        if (this.eeH && this.eeI >= 0) {
            ns(this.eeI);
        }
        this.eeH = false;
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
        k aBU = this.edm.aBU();
        if (aBU != null && aBU.getListView() != null && (frameLayout = (FrameLayout) aBU.aDd()) != null) {
            if (this.dXB == null && this.edm.getPageContext() != null) {
                this.dXB = new TextView(this.edm.getPageContext().getPageActivity());
                this.dXB.setTextSize(0, this.edm.getResources().getDimensionPixelSize(e.C0210e.fontsize28));
                this.dXB.setGravity(17);
            }
            if (this.dXB != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(e.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(e.j.smart_frs_refresh_nodata);
                }
                this.dXB.setText(string);
            }
            al.i(this.dXB, e.d.common_color_10260);
            al.h(this.dXB, e.d.cp_cont_g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(TbadkCoreApplication.getInst(), e.C0210e.ds56));
            if (aBU.aCI() != null && aBU.aCI().getLayoutParams() != null) {
                layoutParams.topMargin = aBU.aCI().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bQt == null) {
                this.bQt = new as();
            }
            this.bQt.a(this.dXB, frameLayout, layoutParams, 2000);
            this.eeI = -1;
        }
    }

    public void ht(boolean z) {
        this.eeH = z;
    }

    public void nt(int i) {
        this.eeI = i;
    }

    public void onDestroy() {
        if (this.bQt != null) {
            this.bQt.onDestroy();
        }
    }
}
