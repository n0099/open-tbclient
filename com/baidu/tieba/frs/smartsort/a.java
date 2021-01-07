package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.frs.q;
/* loaded from: classes2.dex */
public class a {
    private int cEd;
    private final FrsFragment jDI;
    private bb jDb;
    private boolean jFM;
    private int jFN = -1;
    private TextView jxB;

    public a(FrsFragment frsFragment) {
        this.cEd = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.jDI = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cEd = UtilHelper.getStatusBarHeight();
        }
    }

    public void cMF() {
        if (this.jFM && this.jFN >= 0) {
            BC(this.jFN);
        }
        this.jFM = false;
    }

    public void BB(int i) {
        if (i >= 0) {
            rq(true);
            BD(i);
            return;
        }
        rq(false);
        BD(i);
    }

    private void BC(int i) {
        FrameLayout frameLayout;
        String string;
        q cFa = this.jDI.cFa();
        if (cFa != null && cFa.getListView() != null && (frameLayout = (FrameLayout) cFa.cGB()) != null) {
            if (this.jxB == null && this.jDI.getPageContext() != null) {
                this.jxB = new TextView(this.jDI.getPageContext().getPageActivity());
                this.jxB.setTextSize(0, this.jDI.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.jxB.setGravity(17);
            }
            if (this.jxB != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.jxB.setText(string);
            }
            ao.setBackgroundResource(this.jxB, R.color.CAM_X0302);
            ao.setViewTextColor(this.jxB, R.color.CAM_X0112);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.jDb == null) {
                this.jDb = new bb();
            }
            this.jDb.a(this.jxB, frameLayout, layoutParams, 2000);
            this.jFN = -1;
        }
    }

    public void rq(boolean z) {
        this.jFM = z;
    }

    public void BD(int i) {
        this.jFN = i;
    }

    public void onDestroy() {
        if (this.jDb != null) {
            this.jDb.onDestroy();
        }
    }
}
