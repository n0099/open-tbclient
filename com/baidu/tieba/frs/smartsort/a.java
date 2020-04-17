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
    private int byX;
    private TextView hly;
    private aw hqC;
    private final FrsFragment hri;
    private boolean htt;
    private int htu = -1;

    public a(FrsFragment frsFragment) {
        this.byX = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.hri = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.byX = UtilHelper.getStatusBarHeight();
        }
    }

    public void bUq() {
        if (this.htt && this.htu >= 0) {
            uv(this.htu);
        }
        this.htt = false;
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
        n bOx = this.hri.bOx();
        if (bOx != null && bOx.getListView() != null && (frameLayout = (FrameLayout) bOx.bPS()) != null) {
            if (this.hly == null && this.hri.getPageContext() != null) {
                this.hly = new TextView(this.hri.getPageContext().getPageActivity());
                this.hly.setTextSize(0, this.hri.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.hly.setGravity(17);
            }
            if (this.hly != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.hly.setText(string);
            }
            am.setBackgroundResource(this.hly, R.color.cp_link_tip_a);
            am.setViewTextColor(this.hly, (int) R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.hqC == null) {
                this.hqC = new aw();
            }
            this.hqC.a(this.hly, frameLayout, layoutParams, 2000);
            this.htu = -1;
        }
    }

    public void nk(boolean z) {
        this.htt = z;
    }

    public void uw(int i) {
        this.htu = i;
    }

    public void onDestroy() {
        if (this.hqC != null) {
            this.hqC.onDestroy();
        }
    }
}
