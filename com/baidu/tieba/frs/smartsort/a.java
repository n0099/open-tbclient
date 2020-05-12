package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aw;
import com.baidu.tieba.frs.n;
/* loaded from: classes9.dex */
public class a {
    private int bzc;
    private TextView hlE;
    private aw hqI;
    private final FrsFragment hro;
    private int htA = -1;
    private boolean htz;

    public a(FrsFragment frsFragment) {
        this.bzc = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.hro = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bzc = UtilHelper.getStatusBarHeight();
        }
    }

    public void bUp() {
        if (this.htz && this.htA >= 0) {
            uv(this.htA);
        }
        this.htz = false;
    }

    public void uu(int i) {
        if (i >= 0) {
            nk(true);
            uw(i);
            return;
        }
        nk(false);
        uw(i);
    }

    private void uv(int i) {
        FrameLayout frameLayout;
        String string;
        n bOw = this.hro.bOw();
        if (bOw != null && bOw.getListView() != null && (frameLayout = (FrameLayout) bOw.bPR()) != null) {
            if (this.hlE == null && this.hro.getPageContext() != null) {
                this.hlE = new TextView(this.hro.getPageContext().getPageActivity());
                this.hlE.setTextSize(0, this.hro.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.hlE.setGravity(17);
            }
            if (this.hlE != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.hlE.setText(string);
            }
            am.setBackgroundResource(this.hlE, R.color.cp_link_tip_a);
            am.setViewTextColor(this.hlE, (int) R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.hqI == null) {
                this.hqI = new aw();
            }
            this.hqI.a(this.hlE, frameLayout, layoutParams, 2000);
            this.htA = -1;
        }
    }

    public void nk(boolean z) {
        this.htz = z;
    }

    public void uw(int i) {
        this.htA = i;
    }

    public void onDestroy() {
        if (this.hqI != null) {
            this.hqI.onDestroy();
        }
    }
}
