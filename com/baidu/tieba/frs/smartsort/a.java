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
/* loaded from: classes6.dex */
public class a {
    private int aVq;
    private ar gAO;
    private final FrsFragment gBu;
    private boolean gDv;
    private int gDw = -1;
    private TextView gvG;

    public a(FrsFragment frsFragment) {
        this.aVq = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.gBu = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.aVq = UtilHelper.getStatusBarHeight();
        }
    }

    public void bGZ() {
        if (this.gDv && this.gDw >= 0) {
            tG(this.gDw);
        }
        this.gDv = false;
    }

    public void tF(int i) {
        if (i >= 0) {
            lN(true);
            tH(i);
            return;
        }
        lN(false);
        tH(i);
    }

    private void tG(int i) {
        FrameLayout frameLayout;
        String string;
        l bBi = this.gBu.bBi();
        if (bBi != null && bBi.getListView() != null && (frameLayout = (FrameLayout) bBi.bCz()) != null) {
            if (this.gvG == null && this.gBu.getPageContext() != null) {
                this.gvG = new TextView(this.gBu.getPageContext().getPageActivity());
                this.gvG.setTextSize(0, this.gBu.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.gvG.setGravity(17);
            }
            if (this.gvG != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.gvG.setText(string);
            }
            am.setBackgroundResource(this.gvG, R.color.cp_link_tip_a);
            am.setViewTextColor(this.gvG, (int) R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.gAO == null) {
                this.gAO = new ar();
            }
            this.gAO.a(this.gvG, frameLayout, layoutParams, 2000);
            this.gDw = -1;
        }
    }

    public void lN(boolean z) {
        this.gDv = z;
    }

    public void tH(int i) {
        this.gDw = i;
    }

    public void onDestroy() {
        if (this.gAO != null) {
            this.gAO.onDestroy();
        }
    }
}
