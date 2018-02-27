package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.frs.k;
/* loaded from: classes2.dex */
public class b {
    private au cck;
    private TextView dOR;
    private final i dSJ;
    private boolean dTK;
    private int dTL = -1;
    private int duA;

    public b(i iVar) {
        this.duA = 0;
        if (iVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.dSJ = iVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.duA = UtilHelper.getStatusBarHeight();
        }
    }

    public void azK() {
        if (this.dTK && this.dTL >= 0) {
            nK(this.dTL);
        }
        this.dTK = false;
    }

    public void nJ(int i) {
        if (i >= 0) {
            gq(true);
            nL(i);
            return;
        }
        gq(false);
        nL(i);
    }

    private void nK(int i) {
        FrameLayout frameLayout;
        String string;
        k auS = this.dSJ.auS();
        if (auS != null && auS.getListView() != null && (frameLayout = (FrameLayout) auS.avW()) != null) {
            if (this.dOR == null && this.dSJ.getPageContext() != null) {
                this.dOR = new TextView(this.dSJ.getPageContext().getPageActivity());
                this.dOR.setTextSize(0, this.dSJ.getResources().getDimensionPixelSize(d.e.fontsize28));
                this.dOR.setGravity(17);
            }
            if (this.dOR != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_nodata);
                }
                this.dOR.setText(string);
            }
            aj.s(this.dOR, d.C0141d.common_color_10260);
            aj.r(this.dOR, d.C0141d.cp_cont_g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.t(TbadkCoreApplication.getInst(), d.e.ds56));
            if (auS.avC() != null && auS.avC().getLayoutParams() != null) {
                layoutParams.topMargin = auS.avC().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.cck == null) {
                this.cck = new au();
            }
            this.cck.a(this.dOR, frameLayout, layoutParams, 2000);
            this.dTL = -1;
        }
    }

    public void gq(boolean z) {
        this.dTK = z;
    }

    public void nL(int i) {
        this.dTL = i;
    }

    public void onDestroy() {
        if (this.cck != null) {
            this.cck.onDestroy();
        }
    }
}
