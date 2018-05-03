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
    private int cNo;
    private TextView dhz;
    private final FrsFragment dmW;
    private boolean doa;
    private int dob = -1;

    public b(FrsFragment frsFragment) {
        this.cNo = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.dmW = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cNo = UtilHelper.getStatusBarHeight();
        }
    }

    public void auB() {
        if (this.doa && this.dob >= 0) {
            kY(this.dob);
        }
        this.doa = false;
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
        i apn = this.dmW.apn();
        if (apn != null && apn.getListView() != null && (frameLayout = (FrameLayout) apn.aqu()) != null) {
            if (this.dhz == null && this.dmW.getPageContext() != null) {
                this.dhz = new TextView(this.dmW.getPageContext().getPageActivity());
                this.dhz.setTextSize(0, this.dmW.getResources().getDimensionPixelSize(d.e.fontsize28));
                this.dhz.setGravity(17);
            }
            if (this.dhz != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.k.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.k.recommend_frs_refresh_nodata);
                }
                this.dhz.setText(string);
            }
            ak.i(this.dhz, d.C0126d.common_color_10260);
            ak.h(this.dhz, d.C0126d.cp_cont_g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.e(TbadkCoreApplication.getInst(), d.e.ds56));
            if (apn.aqb() != null && apn.aqb().getLayoutParams() != null) {
                layoutParams.topMargin = apn.aqb().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bmn == null) {
                this.bmn = new aq();
            }
            this.bmn.a(this.dhz, frameLayout, layoutParams, 2000);
            this.dob = -1;
        }
    }

    public void fU(boolean z) {
        this.doa = z;
    }

    public void kZ(int i) {
        this.dob = i;
    }

    public void onDestroy() {
        if (this.bmn != null) {
            this.bmn.onDestroy();
        }
    }
}
