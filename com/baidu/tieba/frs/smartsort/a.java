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
    private TextView fHn;
    private aq fMB;
    private final FrsFragment fNh;
    private boolean fPi;
    private int fPj = -1;
    private int fjR;

    public a(FrsFragment frsFragment) {
        this.fjR = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.fNh = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.fjR = UtilHelper.getStatusBarHeight();
        }
    }

    public void bpD() {
        if (this.fPi && this.fPj >= 0) {
            rA(this.fPj);
        }
        this.fPi = false;
    }

    public void rz(int i) {
        if (i >= 0) {
            kB(true);
            rB(i);
            return;
        }
        kB(false);
        rB(i);
    }

    private void rA(int i) {
        FrameLayout frameLayout;
        String string;
        k bjN = this.fNh.bjN();
        if (bjN != null && bjN.getListView() != null && (frameLayout = (FrameLayout) bjN.bld()) != null) {
            if (this.fHn == null && this.fNh.getPageContext() != null) {
                this.fHn = new TextView(this.fNh.getPageContext().getPageActivity());
                this.fHn.setTextSize(0, this.fNh.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.fHn.setGravity(17);
            }
            if (this.fHn != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.fHn.setText(string);
            }
            am.setBackgroundResource(this.fHn, R.color.cp_link_tip_a);
            am.setViewTextColor(this.fHn, (int) R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.fMB == null) {
                this.fMB = new aq();
            }
            this.fMB.a(this.fHn, frameLayout, layoutParams, 2000);
            this.fPj = -1;
        }
    }

    public void kB(boolean z) {
        this.fPi = z;
    }

    public void rB(int i) {
        this.fPj = i;
    }

    public void onDestroy() {
        if (this.fMB != null) {
            this.fMB.onDestroy();
        }
    }
}
