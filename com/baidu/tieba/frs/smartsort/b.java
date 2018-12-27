package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.k;
/* loaded from: classes6.dex */
public class b {
    private as bPI;
    private TextView dWV;
    private int dwK;
    private final FrsFragment ecG;
    private boolean eeb;
    private int eec = -1;

    public b(FrsFragment frsFragment) {
        this.dwK = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.ecG = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dwK = UtilHelper.getStatusBarHeight();
        }
    }

    public void aHx() {
        if (this.eeb && this.eec >= 0) {
            nr(this.eec);
        }
        this.eeb = false;
    }

    public void nq(int i) {
        if (i >= 0) {
            hq(true);
            ns(i);
            return;
        }
        hq(false);
        ns(i);
    }

    private void nr(int i) {
        FrameLayout frameLayout;
        String string;
        k aBx = this.ecG.aBx();
        if (aBx != null && aBx.getListView() != null && (frameLayout = (FrameLayout) aBx.aCG()) != null) {
            if (this.dWV == null && this.ecG.getPageContext() != null) {
                this.dWV = new TextView(this.ecG.getPageContext().getPageActivity());
                this.dWV.setTextSize(0, this.ecG.getResources().getDimensionPixelSize(e.C0210e.fontsize28));
                this.dWV.setGravity(17);
            }
            if (this.dWV != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(e.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(e.j.smart_frs_refresh_nodata);
                }
                this.dWV.setText(string);
            }
            al.i(this.dWV, e.d.common_color_10260);
            al.h(this.dWV, e.d.cp_cont_g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(TbadkCoreApplication.getInst(), e.C0210e.ds56));
            if (aBx.aCl() != null && aBx.aCl().getLayoutParams() != null) {
                layoutParams.topMargin = aBx.aCl().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bPI == null) {
                this.bPI = new as();
            }
            this.bPI.a(this.dWV, frameLayout, layoutParams, 2000);
            this.eec = -1;
        }
    }

    public void hq(boolean z) {
        this.eeb = z;
    }

    public void ns(int i) {
        this.eec = i;
    }

    public void onDestroy() {
        if (this.bPI != null) {
            this.bPI.onDestroy();
        }
    }
}
