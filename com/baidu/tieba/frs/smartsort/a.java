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
    private int cfD;
    private TextView iEw;
    private be iJU;
    private final FrsFragment iKB;
    private boolean iMI;
    private int iMJ = -1;

    public a(FrsFragment frsFragment) {
        this.cfD = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.iKB = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cfD = UtilHelper.getStatusBarHeight();
        }
    }

    public void czd() {
        if (this.iMI && this.iMJ >= 0) {
            zy(this.iMJ);
        }
        this.iMI = false;
    }

    public void zx(int i) {
        if (i >= 0) {
            pN(true);
            zz(i);
            return;
        }
        pN(false);
        zz(i);
    }

    private void zy(int i) {
        FrameLayout frameLayout;
        String string;
        q csD = this.iKB.csD();
        if (csD != null && csD.getListView() != null && (frameLayout = (FrameLayout) csD.cud()) != null) {
            if (this.iEw == null && this.iKB.getPageContext() != null) {
                this.iEw = new TextView(this.iKB.getPageContext().getPageActivity());
                this.iEw.setTextSize(0, this.iKB.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.iEw.setGravity(17);
            }
            if (this.iEw != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.iEw.setText(string);
            }
            ap.setBackgroundResource(this.iEw, R.color.cp_link_tip_a);
            ap.setViewTextColor(this.iEw, R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.iJU == null) {
                this.iJU = new be();
            }
            this.iJU.a(this.iEw, frameLayout, layoutParams, 2000);
            this.iMJ = -1;
        }
    }

    public void pN(boolean z) {
        this.iMI = z;
    }

    public void zz(int i) {
        this.iMJ = i;
    }

    public void onDestroy() {
        if (this.iJU != null) {
            this.iJU.onDestroy();
        }
    }
}
