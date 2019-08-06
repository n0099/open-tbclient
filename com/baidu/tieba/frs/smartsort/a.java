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
    private aq dsF;
    private TextView fGY;
    private final FrsFragment fMP;
    private boolean fOQ;
    private int fOR = -1;
    private int fgh;

    public a(FrsFragment frsFragment) {
        this.fgh = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.fMP = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.fgh = UtilHelper.getStatusBarHeight();
        }
    }

    public void brO() {
        if (this.fOQ && this.fOR >= 0) {
            sE(this.fOR);
        }
        this.fOQ = false;
    }

    public void sD(int i) {
        if (i >= 0) {
            kL(true);
            sF(i);
            return;
        }
        kL(false);
        sF(i);
    }

    private void sE(int i) {
        FrameLayout frameLayout;
        String string;
        k blY = this.fMP.blY();
        if (blY != null && blY.getListView() != null && (frameLayout = (FrameLayout) blY.bnp()) != null) {
            if (this.fGY == null && this.fMP.getPageContext() != null) {
                this.fGY = new TextView(this.fMP.getPageContext().getPageActivity());
                this.fGY.setTextSize(0, this.fMP.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.fGY.setGravity(17);
            }
            if (this.fGY != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.fGY.setText(string);
            }
            am.k(this.fGY, R.color.cp_link_tip_a);
            am.j(this.fGY, R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.dsF == null) {
                this.dsF = new aq();
            }
            this.dsF.a(this.fGY, frameLayout, layoutParams, 2000);
            this.fOR = -1;
        }
    }

    public void kL(boolean z) {
        this.fOQ = z;
    }

    public void sF(int i) {
        this.fOR = i;
    }

    public void onDestroy() {
        if (this.dsF != null) {
            this.dsF.onDestroy();
        }
    }
}
