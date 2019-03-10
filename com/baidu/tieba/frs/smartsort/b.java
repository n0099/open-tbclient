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
    private aq dfL;
    private int eKN;
    private TextView flf;
    private final FrsFragment fqT;
    private boolean fsZ;
    private int fta = -1;

    public b(FrsFragment frsFragment) {
        this.eKN = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.fqT = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.eKN = UtilHelper.getStatusBarHeight();
        }
    }

    public void bik() {
        if (this.fsZ && this.fta >= 0) {
            rg(this.fta);
        }
        this.fsZ = false;
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
        k bcv = this.fqT.bcv();
        if (bcv != null && bcv.getListView() != null && (frameLayout = (FrameLayout) bcv.bdN()) != null) {
            if (this.flf == null && this.fqT.getPageContext() != null) {
                this.flf = new TextView(this.fqT.getPageContext().getPageActivity());
                this.flf.setTextSize(0, this.fqT.getResources().getDimensionPixelSize(d.e.fontsize28));
                this.flf.setGravity(17);
            }
            if (this.flf != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.j.smart_frs_refresh_nodata);
                }
                this.flf.setText(string);
            }
            al.k(this.flf, d.C0236d.cp_link_tip_a);
            al.j(this.flf, d.C0236d.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(TbadkCoreApplication.getInst(), d.e.ds56));
            if (this.dfL == null) {
                this.dfL = new aq();
            }
            this.dfL.a(this.flf, frameLayout, layoutParams, 2000);
            this.fta = -1;
        }
    }

    public void jO(boolean z) {
        this.fsZ = z;
    }

    public void rh(int i) {
        this.fta = i;
    }

    public void onDestroy() {
        if (this.dfL != null) {
            this.dfL.onDestroy();
        }
    }
}
