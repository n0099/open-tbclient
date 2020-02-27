package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.l;
/* loaded from: classes9.dex */
public class a {
    private int bau;
    private TextView gAQ;
    private ar gFX;
    private final FrsFragment gGD;
    private boolean gIJ;
    private int gIK = -1;

    public a(FrsFragment frsFragment) {
        this.bau = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.gGD = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bau = UtilHelper.getStatusBarHeight();
        }
    }

    public void bJD() {
        if (this.gIJ && this.gIK >= 0) {
            tR(this.gIK);
        }
        this.gIJ = false;
    }

    public void tQ(int i) {
        if (i >= 0) {
            ma(true);
            tS(i);
            return;
        }
        ma(false);
        tS(i);
    }

    private void tR(int i) {
        FrameLayout frameLayout;
        String string;
        l bDN = this.gGD.bDN();
        if (bDN != null && bDN.getListView() != null && (frameLayout = (FrameLayout) bDN.bFe()) != null) {
            if (this.gAQ == null && this.gGD.getPageContext() != null) {
                this.gAQ = new TextView(this.gGD.getPageContext().getPageActivity());
                this.gAQ.setTextSize(0, this.gGD.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.gAQ.setGravity(17);
            }
            if (this.gAQ != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.gAQ.setText(string);
            }
            am.setBackgroundResource(this.gAQ, R.color.cp_link_tip_a);
            am.setViewTextColor(this.gAQ, (int) R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.gFX == null) {
                this.gFX = new ar();
            }
            this.gFX.a(this.gAQ, frameLayout, layoutParams, 2000);
            this.gIK = -1;
        }
    }

    public void ma(boolean z) {
        this.gIJ = z;
    }

    public void tS(int i) {
        this.gIK = i;
    }

    public void onDestroy() {
        if (this.gFX != null) {
            this.gFX.onDestroy();
        }
    }
}
