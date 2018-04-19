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
    private aq bmn;
    private int cNr;
    private TextView dhC;
    private final FrsFragment dmZ;
    private boolean doe;
    private int dof = -1;

    public b(FrsFragment frsFragment) {
        this.cNr = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.dmZ = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cNr = UtilHelper.getStatusBarHeight();
        }
    }

    public void auB() {
        if (this.doe && this.dof >= 0) {
            kY(this.dof);
        }
        this.doe = false;
    }

    public void kX(int i) {
        if (i >= 0) {
            fU(true);
            kZ(i);
            return;
        }
        fU(false);
        kZ(i);
    }

    private void kY(int i) {
        FrameLayout frameLayout;
        String string;
        i apn = this.dmZ.apn();
        if (apn != null && apn.getListView() != null && (frameLayout = (FrameLayout) apn.aqu()) != null) {
            if (this.dhC == null && this.dmZ.getPageContext() != null) {
                this.dhC = new TextView(this.dmZ.getPageContext().getPageActivity());
                this.dhC.setTextSize(0, this.dmZ.getResources().getDimensionPixelSize(d.e.fontsize28));
                this.dhC.setGravity(17);
            }
            if (this.dhC != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.k.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.k.recommend_frs_refresh_nodata);
                }
                this.dhC.setText(string);
            }
            ak.i(this.dhC, d.C0126d.common_color_10260);
            ak.h(this.dhC, d.C0126d.cp_cont_g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.e(TbadkCoreApplication.getInst(), d.e.ds56));
            if (apn.aqb() != null && apn.aqb().getLayoutParams() != null) {
                layoutParams.topMargin = apn.aqb().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bmn == null) {
                this.bmn = new aq();
            }
            this.bmn.a(this.dhC, frameLayout, layoutParams, 2000);
            this.dof = -1;
        }
    }

    public void fU(boolean z) {
        this.doe = z;
    }

    public void kZ(int i) {
        this.dof = i;
    }

    public void onDestroy() {
        if (this.bmn != null) {
            this.bmn.onDestroy();
        }
    }
}
