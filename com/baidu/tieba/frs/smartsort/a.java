package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.frs.q;
/* loaded from: classes22.dex */
public class a {
    private int coc;
    private TextView iQS;
    private final FrsFragment iWX;
    private be iWq;
    private boolean iZe;
    private int iZf = -1;

    public a(FrsFragment frsFragment) {
        this.coc = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.iWX = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.coc = UtilHelper.getStatusBarHeight();
        }
    }

    public void cCk() {
        if (this.iZe && this.iZf >= 0) {
            zR(this.iZf);
        }
        this.iZe = false;
    }

    public void zQ(int i) {
        if (i >= 0) {
            qf(true);
            zS(i);
            return;
        }
        qf(false);
        zS(i);
    }

    private void zR(int i) {
        FrameLayout frameLayout;
        String string;
        q cvK = this.iWX.cvK();
        if (cvK != null && cvK.getListView() != null && (frameLayout = (FrameLayout) cvK.cxk()) != null) {
            if (this.iQS == null && this.iWX.getPageContext() != null) {
                this.iQS = new TextView(this.iWX.getPageContext().getPageActivity());
                this.iQS.setTextSize(0, this.iWX.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.iQS.setGravity(17);
            }
            if (this.iQS != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.iQS.setText(string);
            }
            ap.setBackgroundResource(this.iQS, R.color.cp_link_tip_a);
            ap.setViewTextColor(this.iQS, R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.iWq == null) {
                this.iWq = new be();
            }
            this.iWq.a(this.iQS, frameLayout, layoutParams, 2000);
            this.iZf = -1;
        }
    }

    public void qf(boolean z) {
        this.iZe = z;
    }

    public void zS(int i) {
        this.iZf = i;
    }

    public void onDestroy() {
        if (this.iWq != null) {
            this.iWq.onDestroy();
        }
    }
}
