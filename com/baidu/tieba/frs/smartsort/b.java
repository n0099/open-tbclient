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
    private au cam;
    private TextView dMe;
    private final i dPK;
    private boolean dQL;
    private int dQM = -1;
    private int drT;

    public b(i iVar) {
        this.drT = 0;
        if (iVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.dPK = iVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.drT = UtilHelper.getStatusBarHeight();
        }
    }

    public void ayJ() {
        if (this.dQL && this.dQM >= 0) {
            nK(this.dQM);
        }
        this.dQL = false;
    }

    public void nJ(int i) {
        if (i >= 0) {
            gh(true);
            nL(i);
            return;
        }
        gh(false);
        nL(i);
    }

    private void nK(int i) {
        FrameLayout frameLayout;
        String string;
        k aud = this.dPK.aud();
        if (aud != null && aud.getListView() != null && (frameLayout = (FrameLayout) aud.auV()) != null) {
            if (this.dMe == null && this.dPK.getPageContext() != null) {
                this.dMe = new TextView(this.dPK.getPageContext().getPageActivity());
                this.dMe.setTextSize(0, this.dPK.getResources().getDimensionPixelSize(d.e.fontsize28));
                this.dMe.setGravity(17);
            }
            if (this.dMe != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_nodata);
                }
                this.dMe.setText(string);
            }
            aj.s(this.dMe, d.C0108d.common_color_10260);
            aj.r(this.dMe, d.C0108d.cp_cont_g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.s(TbadkCoreApplication.getInst(), d.e.ds56));
            if (aud.auD() != null && aud.auD().getLayoutParams() != null) {
                layoutParams.topMargin = aud.auD().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.cam == null) {
                this.cam = new au();
            }
            this.cam.a(this.dMe, frameLayout, layoutParams, 2000);
            this.dQM = -1;
        }
    }

    public void gh(boolean z) {
        this.dQL = z;
    }

    public void nL(int i) {
        this.dQM = i;
    }

    public void onDestroy() {
        if (this.cam != null) {
            this.cam.onDestroy();
        }
    }
}
