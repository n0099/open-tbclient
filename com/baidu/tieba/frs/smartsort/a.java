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
    private int czr;
    private boolean jBg;
    private int jBh = -1;
    private TextView jsV;
    private bb jyv;
    private final FrsFragment jzc;

    public a(FrsFragment frsFragment) {
        this.czr = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.jzc = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.czr = UtilHelper.getStatusBarHeight();
        }
    }

    public void cIN() {
        if (this.jBg && this.jBh >= 0) {
            zW(this.jBh);
        }
        this.jBg = false;
    }

    public void zV(int i) {
        if (i >= 0) {
            rm(true);
            zX(i);
            return;
        }
        rm(false);
        zX(i);
    }

    private void zW(int i) {
        FrameLayout frameLayout;
        String string;
        q cBi = this.jzc.cBi();
        if (cBi != null && cBi.getListView() != null && (frameLayout = (FrameLayout) cBi.cCJ()) != null) {
            if (this.jsV == null && this.jzc.getPageContext() != null) {
                this.jsV = new TextView(this.jzc.getPageContext().getPageActivity());
                this.jsV.setTextSize(0, this.jzc.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.jsV.setGravity(17);
            }
            if (this.jsV != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.jsV.setText(string);
            }
            ao.setBackgroundResource(this.jsV, R.color.CAM_X0302);
            ao.setViewTextColor(this.jsV, R.color.CAM_X0112);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.jyv == null) {
                this.jyv = new bb();
            }
            this.jyv.a(this.jsV, frameLayout, layoutParams, 2000);
            this.jBh = -1;
        }
    }

    public void rm(boolean z) {
        this.jBg = z;
    }

    public void zX(int i) {
        this.jBh = i;
    }

    public void onDestroy() {
        if (this.jyv != null) {
            this.jyv.onDestroy();
        }
    }
}
