package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.k;
/* loaded from: classes2.dex */
public class b {
    private as bwd;
    private int cVD;
    private final FrsFragment dAK;
    private boolean dBP;
    private int dBQ = -1;
    private TextView dve;

    public b(FrsFragment frsFragment) {
        this.cVD = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.dAK = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cVD = UtilHelper.getStatusBarHeight();
        }
    }

    public void azu() {
        if (this.dBP && this.dBQ >= 0) {
            ll(this.dBQ);
        }
        this.dBP = false;
    }

    public void lk(int i) {
        if (i >= 0) {
            gl(true);
            lm(i);
            return;
        }
        gl(false);
        lm(i);
    }

    private void ll(int i) {
        FrameLayout frameLayout;
        String string;
        k atI = this.dAK.atI();
        if (atI != null && atI.getListView() != null && (frameLayout = (FrameLayout) atI.auR()) != null) {
            if (this.dve == null && this.dAK.getPageContext() != null) {
                this.dve = new TextView(this.dAK.getPageContext().getPageActivity());
                this.dve.setTextSize(0, this.dAK.getResources().getDimensionPixelSize(d.e.fontsize28));
                this.dve.setGravity(17);
            }
            if (this.dve != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.k.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.k.smart_frs_refresh_nodata);
                }
                this.dve.setText(string);
            }
            am.i(this.dve, d.C0142d.common_color_10260);
            am.h(this.dve, d.C0142d.cp_cont_g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.e(TbadkCoreApplication.getInst(), d.e.ds56));
            if (atI.aux() != null && atI.aux().getLayoutParams() != null) {
                layoutParams.topMargin = atI.aux().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bwd == null) {
                this.bwd = new as();
            }
            this.bwd.a(this.dve, frameLayout, layoutParams, 2000);
            this.dBQ = -1;
        }
    }

    public void gl(boolean z) {
        this.dBP = z;
    }

    public void lm(int i) {
        this.dBQ = i;
    }

    public void onDestroy() {
        if (this.bwd != null) {
            this.bwd.onDestroy();
        }
    }
}
