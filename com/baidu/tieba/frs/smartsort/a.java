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
/* loaded from: classes7.dex */
public class a {
    private int aWi;
    private ar gDY;
    private final FrsFragment gEE;
    private boolean gGK;
    private int gGL = -1;
    private TextView gyQ;

    public a(FrsFragment frsFragment) {
        this.aWi = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.gEE = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.aWi = UtilHelper.getStatusBarHeight();
        }
    }

    public void bIb() {
        if (this.gGK && this.gGL >= 0) {
            tL(this.gGL);
        }
        this.gGK = false;
    }

    public void tK(int i) {
        if (i >= 0) {
            lY(true);
            tM(i);
            return;
        }
        lY(false);
        tM(i);
    }

    private void tL(int i) {
        FrameLayout frameLayout;
        String string;
        l bCk = this.gEE.bCk();
        if (bCk != null && bCk.getListView() != null && (frameLayout = (FrameLayout) bCk.bDB()) != null) {
            if (this.gyQ == null && this.gEE.getPageContext() != null) {
                this.gyQ = new TextView(this.gEE.getPageContext().getPageActivity());
                this.gyQ.setTextSize(0, this.gEE.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.gyQ.setGravity(17);
            }
            if (this.gyQ != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.gyQ.setText(string);
            }
            am.setBackgroundResource(this.gyQ, R.color.cp_link_tip_a);
            am.setViewTextColor(this.gyQ, (int) R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.gDY == null) {
                this.gDY = new ar();
            }
            this.gDY.a(this.gyQ, frameLayout, layoutParams, 2000);
            this.gGL = -1;
        }
    }

    public void lY(boolean z) {
        this.gGK = z;
    }

    public void tM(int i) {
        this.gGL = i;
    }

    public void onDestroy() {
        if (this.gDY != null) {
            this.gDY.onDestroy();
        }
    }
}
