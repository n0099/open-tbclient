package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.k;
/* loaded from: classes4.dex */
public class a {
    private TextView fIe;
    private final FrsFragment fNY;
    private aq fNs;
    private boolean fPZ;
    private int fQa = -1;
    private int fkI;

    public a(FrsFragment frsFragment) {
        this.fkI = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.fNY = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.fkI = UtilHelper.getStatusBarHeight();
        }
    }

    public void bpF() {
        if (this.fPZ && this.fQa >= 0) {
            rB(this.fQa);
        }
        this.fPZ = false;
    }

    public void rA(int i) {
        if (i >= 0) {
            kB(true);
            rC(i);
            return;
        }
        kB(false);
        rC(i);
    }

    private void rB(int i) {
        FrameLayout frameLayout;
        String string;
        k bjP = this.fNY.bjP();
        if (bjP != null && bjP.getListView() != null && (frameLayout = (FrameLayout) bjP.blf()) != null) {
            if (this.fIe == null && this.fNY.getPageContext() != null) {
                this.fIe = new TextView(this.fNY.getPageContext().getPageActivity());
                this.fIe.setTextSize(0, this.fNY.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.fIe.setGravity(17);
            }
            if (this.fIe != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.fIe.setText(string);
            }
            am.setBackgroundResource(this.fIe, R.color.cp_link_tip_a);
            am.setViewTextColor(this.fIe, (int) R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.fNs == null) {
                this.fNs = new aq();
            }
            this.fNs.a(this.fIe, frameLayout, layoutParams, 2000);
            this.fQa = -1;
        }
    }

    public void kB(boolean z) {
        this.fPZ = z;
    }

    public void rC(int i) {
        this.fQa = i;
    }

    public void onDestroy() {
        if (this.fNs != null) {
            this.fNs.onDestroy();
        }
    }
}
