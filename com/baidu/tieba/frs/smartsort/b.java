package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.i;
/* loaded from: classes2.dex */
public class b {
    private aq bmC;
    private int cOv;
    private TextView diG;
    private final FrsFragment dof;
    private boolean dpj;
    private int dpk = -1;

    public b(FrsFragment frsFragment) {
        this.cOv = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.dof = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cOv = UtilHelper.getStatusBarHeight();
        }
    }

    public void auB() {
        if (this.dpj && this.dpk >= 0) {
            kX(this.dpk);
        }
        this.dpj = false;
    }

    public void kW(int i) {
        if (i >= 0) {
            fV(true);
            kY(i);
            return;
        }
        fV(false);
        kY(i);
    }

    private void kX(int i) {
        FrameLayout frameLayout;
        String string;
        i apm = this.dof.apm();
        if (apm != null && apm.getListView() != null && (frameLayout = (FrameLayout) apm.aqt()) != null) {
            if (this.diG == null && this.dof.getPageContext() != null) {
                this.diG = new TextView(this.dof.getPageContext().getPageActivity());
                this.diG.setTextSize(0, this.dof.getResources().getDimensionPixelSize(d.e.fontsize28));
                this.diG.setGravity(17);
            }
            if (this.diG != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.k.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.k.recommend_frs_refresh_nodata);
                }
                this.diG.setText(string);
            }
            ak.i(this.diG, d.C0126d.common_color_10260);
            ak.h(this.diG, d.C0126d.cp_cont_g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.e(TbadkCoreApplication.getInst(), d.e.ds56));
            if (apm.aqa() != null && apm.aqa().getLayoutParams() != null) {
                layoutParams.topMargin = apm.aqa().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bmC == null) {
                this.bmC = new aq();
            }
            this.bmC.a(this.diG, frameLayout, layoutParams, 2000);
            this.dpk = -1;
        }
    }

    public void fV(boolean z) {
        this.dpj = z;
    }

    public void kY(int i) {
        this.dpk = i;
    }

    public void onDestroy() {
        if (this.bmC != null) {
            this.bmC.onDestroy();
        }
    }
}
