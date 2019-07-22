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
    private aq dsy;
    private TextView fGk;
    private final FrsFragment fMb;
    private boolean fOc;
    private int fOd = -1;
    private int ffH;

    public a(FrsFragment frsFragment) {
        this.ffH = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.fMb = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.ffH = UtilHelper.getStatusBarHeight();
        }
    }

    public void brB() {
        if (this.fOc && this.fOd >= 0) {
            sC(this.fOd);
        }
        this.fOc = false;
    }

    public void sB(int i) {
        if (i >= 0) {
            kL(true);
            sD(i);
            return;
        }
        kL(false);
        sD(i);
    }

    private void sC(int i) {
        FrameLayout frameLayout;
        String string;
        k blR = this.fMb.blR();
        if (blR != null && blR.getListView() != null && (frameLayout = (FrameLayout) blR.bnf()) != null) {
            if (this.fGk == null && this.fMb.getPageContext() != null) {
                this.fGk = new TextView(this.fMb.getPageContext().getPageActivity());
                this.fGk.setTextSize(0, this.fMb.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.fGk.setGravity(17);
            }
            if (this.fGk != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.fGk.setText(string);
            }
            am.k(this.fGk, R.color.cp_link_tip_a);
            am.j(this.fGk, R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.dsy == null) {
                this.dsy = new aq();
            }
            this.dsy.a(this.fGk, frameLayout, layoutParams, 2000);
            this.fOd = -1;
        }
    }

    public void kL(boolean z) {
        this.fOc = z;
    }

    public void sD(int i) {
        this.fOd = i;
    }

    public void onDestroy() {
        if (this.dsy != null) {
            this.dsy.onDestroy();
        }
    }
}
