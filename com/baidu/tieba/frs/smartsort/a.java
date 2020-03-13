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
    private int baw;
    private TextView gBe;
    private final FrsFragment gGR;
    private ar gGl;
    private boolean gIX;
    private int gIY = -1;

    public a(FrsFragment frsFragment) {
        this.baw = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.gGR = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.baw = UtilHelper.getStatusBarHeight();
        }
    }

    public void bJG() {
        if (this.gIX && this.gIY >= 0) {
            tR(this.gIY);
        }
        this.gIX = false;
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
        l bDQ = this.gGR.bDQ();
        if (bDQ != null && bDQ.getListView() != null && (frameLayout = (FrameLayout) bDQ.bFh()) != null) {
            if (this.gBe == null && this.gGR.getPageContext() != null) {
                this.gBe = new TextView(this.gGR.getPageContext().getPageActivity());
                this.gBe.setTextSize(0, this.gGR.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.gBe.setGravity(17);
            }
            if (this.gBe != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.gBe.setText(string);
            }
            am.setBackgroundResource(this.gBe, R.color.cp_link_tip_a);
            am.setViewTextColor(this.gBe, (int) R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.gGl == null) {
                this.gGl = new ar();
            }
            this.gGl.a(this.gBe, frameLayout, layoutParams, 2000);
            this.gIY = -1;
        }
    }

    public void ma(boolean z) {
        this.gIX = z;
    }

    public void tS(int i) {
        this.gIY = i;
    }

    public void onDestroy() {
        if (this.gGl != null) {
            this.gGl.onDestroy();
        }
    }
}
