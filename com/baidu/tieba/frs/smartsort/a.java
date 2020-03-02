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
    private int bav;
    private TextView gAS;
    private ar gFZ;
    private final FrsFragment gGF;
    private boolean gIL;
    private int gIM = -1;

    public a(FrsFragment frsFragment) {
        this.bav = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.gGF = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bav = UtilHelper.getStatusBarHeight();
        }
    }

    public void bJF() {
        if (this.gIL && this.gIM >= 0) {
            tR(this.gIM);
        }
        this.gIL = false;
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
        l bDP = this.gGF.bDP();
        if (bDP != null && bDP.getListView() != null && (frameLayout = (FrameLayout) bDP.bFg()) != null) {
            if (this.gAS == null && this.gGF.getPageContext() != null) {
                this.gAS = new TextView(this.gGF.getPageContext().getPageActivity());
                this.gAS.setTextSize(0, this.gGF.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.gAS.setGravity(17);
            }
            if (this.gAS != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.gAS.setText(string);
            }
            am.setBackgroundResource(this.gAS, R.color.cp_link_tip_a);
            am.setViewTextColor(this.gAS, (int) R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.gFZ == null) {
                this.gFZ = new ar();
            }
            this.gFZ.a(this.gAS, frameLayout, layoutParams, 2000);
            this.gIM = -1;
        }
    }

    public void ma(boolean z) {
        this.gIL = z;
    }

    public void tS(int i) {
        this.gIM = i;
    }

    public void onDestroy() {
        if (this.gFZ != null) {
            this.gFZ.onDestroy();
        }
    }
}
