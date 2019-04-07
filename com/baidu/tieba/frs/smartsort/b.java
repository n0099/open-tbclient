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
    private int eKv;
    private TextView fkQ;
    private final FrsFragment fqE;
    private boolean fsK;
    private int fsL = -1;

    public b(FrsFragment frsFragment) {
        this.eKv = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.fqE = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.eKv = UtilHelper.getStatusBarHeight();
        }
    }

    public void bih() {
        if (this.fsK && this.fsL >= 0) {
            rc(this.fsL);
        }
        this.fsK = false;
    }

    public void rb(int i) {
        if (i >= 0) {
            jO(true);
            rd(i);
            return;
        }
        jO(false);
        rd(i);
    }

    private void rc(int i) {
        FrameLayout frameLayout;
        String string;
        k bcs = this.fqE.bcs();
        if (bcs != null && bcs.getListView() != null && (frameLayout = (FrameLayout) bcs.bdK()) != null) {
            if (this.fkQ == null && this.fqE.getPageContext() != null) {
                this.fkQ = new TextView(this.fqE.getPageContext().getPageActivity());
                this.fkQ.setTextSize(0, this.fqE.getResources().getDimensionPixelSize(d.e.fontsize28));
                this.fkQ.setGravity(17);
            }
            if (this.fkQ != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.j.smart_frs_refresh_nodata);
                }
                this.fkQ.setText(string);
            }
            al.k(this.fkQ, d.C0277d.cp_link_tip_a);
            al.j(this.fkQ, d.C0277d.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(TbadkCoreApplication.getInst(), d.e.ds56));
            if (this.dfL == null) {
                this.dfL = new aq();
            }
            this.dfL.a(this.fkQ, frameLayout, layoutParams, 2000);
            this.fsL = -1;
        }
    }

    public void jO(boolean z) {
        this.fsK = z;
    }

    public void rd(int i) {
        this.fsL = i;
    }

    public void onDestroy() {
        if (this.dfL != null) {
            this.dfL.onDestroy();
        }
    }
}
