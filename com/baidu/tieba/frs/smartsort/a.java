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
    private aq duq;
    private TextView fIN;
    private final FrsFragment fOE;
    private boolean fQG;
    private int fQH = -1;
    private int fhU;

    public a(FrsFragment frsFragment) {
        this.fhU = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.fOE = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.fhU = UtilHelper.getStatusBarHeight();
        }
    }

    public void bsB() {
        if (this.fQG && this.fQH >= 0) {
            sI(this.fQH);
        }
        this.fQG = false;
    }

    public void sH(int i) {
        if (i >= 0) {
            kO(true);
            sJ(i);
            return;
        }
        kO(false);
        sJ(i);
    }

    private void sI(int i) {
        FrameLayout frameLayout;
        String string;
        k bmJ = this.fOE.bmJ();
        if (bmJ != null && bmJ.getListView() != null && (frameLayout = (FrameLayout) bmJ.boa()) != null) {
            if (this.fIN == null && this.fOE.getPageContext() != null) {
                this.fIN = new TextView(this.fOE.getPageContext().getPageActivity());
                this.fIN.setTextSize(0, this.fOE.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.fIN.setGravity(17);
            }
            if (this.fIN != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.fIN.setText(string);
            }
            am.k(this.fIN, R.color.cp_link_tip_a);
            am.j(this.fIN, R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.duq == null) {
                this.duq = new aq();
            }
            this.duq.a(this.fIN, frameLayout, layoutParams, 2000);
            this.fQH = -1;
        }
    }

    public void kO(boolean z) {
        this.fQG = z;
    }

    public void sJ(int i) {
        this.fQH = i;
    }

    public void onDestroy() {
        if (this.duq != null) {
            this.duq.onDestroy();
        }
    }
}
