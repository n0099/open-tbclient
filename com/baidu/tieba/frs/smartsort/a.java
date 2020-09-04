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
/* loaded from: classes16.dex */
public class a {
    private int bRp;
    private TextView iiB;
    private be inL;
    private final FrsFragment ios;
    private int iqA = -1;
    private boolean iqz;

    public a(FrsFragment frsFragment) {
        this.bRp = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.ios = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bRp = UtilHelper.getStatusBarHeight();
        }
    }

    public void csr() {
        if (this.iqz && this.iqA >= 0) {
            yt(this.iqA);
        }
        this.iqz = false;
    }

    public void ys(int i) {
        if (i >= 0) {
            pc(true);
            yu(i);
            return;
        }
        pc(false);
        yu(i);
    }

    private void yt(int i) {
        FrameLayout frameLayout;
        String string;
        q clT = this.ios.clT();
        if (clT != null && clT.getListView() != null && (frameLayout = (FrameLayout) clT.cnt()) != null) {
            if (this.iiB == null && this.ios.getPageContext() != null) {
                this.iiB = new TextView(this.ios.getPageContext().getPageActivity());
                this.iiB.setTextSize(0, this.ios.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.iiB.setGravity(17);
            }
            if (this.iiB != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.iiB.setText(string);
            }
            ap.setBackgroundResource(this.iiB, R.color.cp_link_tip_a);
            ap.setViewTextColor(this.iiB, R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.inL == null) {
                this.inL = new be();
            }
            this.inL.a(this.iiB, frameLayout, layoutParams, 2000);
            this.iqA = -1;
        }
    }

    public void pc(boolean z) {
        this.iqz = z;
    }

    public void yu(int i) {
        this.iqA = i;
    }

    public void onDestroy() {
        if (this.inL != null) {
            this.inL.onDestroy();
        }
    }
}
