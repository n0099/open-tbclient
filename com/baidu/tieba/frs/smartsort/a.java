package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.k;
/* loaded from: classes4.dex */
public class a {
    private aq dqp;
    private TextView fBm;
    private final FrsFragment fHd;
    private boolean fJe;
    private int fJf = -1;
    private int faG;

    public a(FrsFragment frsFragment) {
        this.faG = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.fHd = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.faG = UtilHelper.getStatusBarHeight();
        }
    }

    public void bpA() {
        if (this.fJe && this.fJf >= 0) {
            sk(this.fJf);
        }
        this.fJe = false;
    }

    public void sj(int i) {
        if (i >= 0) {
            kB(true);
            sl(i);
            return;
        }
        kB(false);
        sl(i);
    }

    private void sk(int i) {
        FrameLayout frameLayout;
        String string;
        k bjP = this.fHd.bjP();
        if (bjP != null && bjP.getListView() != null && (frameLayout = (FrameLayout) bjP.ble()) != null) {
            if (this.fBm == null && this.fHd.getPageContext() != null) {
                this.fBm = new TextView(this.fHd.getPageContext().getPageActivity());
                this.fBm.setTextSize(0, this.fHd.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.fBm.setGravity(17);
            }
            if (this.fBm != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.fBm.setText(string);
            }
            al.k(this.fBm, R.color.cp_link_tip_a);
            al.j(this.fBm, R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.dqp == null) {
                this.dqp = new aq();
            }
            this.dqp.a(this.fBm, frameLayout, layoutParams, 2000);
            this.fJf = -1;
        }
    }

    public void kB(boolean z) {
        this.fJe = z;
    }

    public void sl(int i) {
        this.fJf = i;
    }

    public void onDestroy() {
        if (this.dqp != null) {
            this.dqp.onDestroy();
        }
    }
}
