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
    private int bRl;
    private TextView iiv;
    private be inF;
    private final FrsFragment iom;
    private boolean iqt;
    private int iqu = -1;

    public a(FrsFragment frsFragment) {
        this.bRl = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.iom = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bRl = UtilHelper.getStatusBarHeight();
        }
    }

    public void csq() {
        if (this.iqt && this.iqu >= 0) {
            yt(this.iqu);
        }
        this.iqt = false;
    }

    public void ys(int i) {
        if (i >= 0) {
            pa(true);
            yu(i);
            return;
        }
        pa(false);
        yu(i);
    }

    private void yt(int i) {
        FrameLayout frameLayout;
        String string;
        q clS = this.iom.clS();
        if (clS != null && clS.getListView() != null && (frameLayout = (FrameLayout) clS.cns()) != null) {
            if (this.iiv == null && this.iom.getPageContext() != null) {
                this.iiv = new TextView(this.iom.getPageContext().getPageActivity());
                this.iiv.setTextSize(0, this.iom.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.iiv.setGravity(17);
            }
            if (this.iiv != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.iiv.setText(string);
            }
            ap.setBackgroundResource(this.iiv, R.color.cp_link_tip_a);
            ap.setViewTextColor(this.iiv, R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.inF == null) {
                this.inF = new be();
            }
            this.inF.a(this.iiv, frameLayout, layoutParams, 2000);
            this.iqu = -1;
        }
    }

    public void pa(boolean z) {
        this.iqt = z;
    }

    public void yu(int i) {
        this.iqu = i;
    }

    public void onDestroy() {
        if (this.inF != null) {
            this.inF.onDestroy();
        }
    }
}
