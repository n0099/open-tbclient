package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.m;
/* loaded from: classes9.dex */
public class a {
    private int baJ;
    private TextView gCc;
    private final FrsFragment gHP;
    private as gHj;
    private boolean gKc;
    private int gKd = -1;

    public a(FrsFragment frsFragment) {
        this.baJ = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.gHP = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.baJ = UtilHelper.getStatusBarHeight();
        }
    }

    public void bJT() {
        if (this.gKc && this.gKd >= 0) {
            tX(this.gKd);
        }
        this.gKc = false;
    }

    public void tW(int i) {
        if (i >= 0) {
            mg(true);
            tY(i);
            return;
        }
        mg(false);
        tY(i);
    }

    private void tX(int i) {
        FrameLayout frameLayout;
        String string;
        m bDY = this.gHP.bDY();
        if (bDY != null && bDY.getListView() != null && (frameLayout = (FrameLayout) bDY.bFr()) != null) {
            if (this.gCc == null && this.gHP.getPageContext() != null) {
                this.gCc = new TextView(this.gHP.getPageContext().getPageActivity());
                this.gCc.setTextSize(0, this.gHP.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.gCc.setGravity(17);
            }
            if (this.gCc != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.gCc.setText(string);
            }
            am.setBackgroundResource(this.gCc, R.color.cp_link_tip_a);
            am.setViewTextColor(this.gCc, (int) R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.gHj == null) {
                this.gHj = new as();
            }
            this.gHj.a(this.gCc, frameLayout, layoutParams, 2000);
            this.gKd = -1;
        }
    }

    public void mg(boolean z) {
        this.gKc = z;
    }

    public void tY(int i) {
        this.gKd = i;
    }

    public void onDestroy() {
        if (this.gHj != null) {
            this.gHj.onDestroy();
        }
    }
}
