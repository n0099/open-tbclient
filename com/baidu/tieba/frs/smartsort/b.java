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
import com.baidu.tieba.frs.k;
/* loaded from: classes4.dex */
public class b {
    private aq dfH;
    private int eKJ;
    private TextView fle;
    private final FrsFragment fqS;
    private boolean fsY;
    private int fsZ = -1;

    public b(FrsFragment frsFragment) {
        this.eKJ = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.fqS = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.eKJ = UtilHelper.getStatusBarHeight();
        }
    }

    public void bij() {
        if (this.fsY && this.fsZ >= 0) {
            rg(this.fsZ);
        }
        this.fsY = false;
    }

    public void rf(int i) {
        if (i >= 0) {
            jO(true);
            rh(i);
            return;
        }
        jO(false);
        rh(i);
    }

    private void rg(int i) {
        FrameLayout frameLayout;
        String string;
        k bcu = this.fqS.bcu();
        if (bcu != null && bcu.getListView() != null && (frameLayout = (FrameLayout) bcu.bdM()) != null) {
            if (this.fle == null && this.fqS.getPageContext() != null) {
                this.fle = new TextView(this.fqS.getPageContext().getPageActivity());
                this.fle.setTextSize(0, this.fqS.getResources().getDimensionPixelSize(d.e.fontsize28));
                this.fle.setGravity(17);
            }
            if (this.fle != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.j.smart_frs_refresh_nodata);
                }
                this.fle.setText(string);
            }
            al.k(this.fle, d.C0277d.cp_link_tip_a);
            al.j(this.fle, d.C0277d.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(TbadkCoreApplication.getInst(), d.e.ds56));
            if (this.dfH == null) {
                this.dfH = new aq();
            }
            this.dfH.a(this.fle, frameLayout, layoutParams, 2000);
            this.fsZ = -1;
        }
    }

    public void jO(boolean z) {
        this.fsY = z;
    }

    public void rh(int i) {
        this.fsZ = i;
    }

    public void onDestroy() {
        if (this.dfH != null) {
            this.dfH.onDestroy();
        }
    }
}
