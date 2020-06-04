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
    private int bGF;
    private TextView hBf;
    private final FrsFragment hGQ;
    private aw hGj;
    private boolean hJa;
    private int hJb = -1;

    public a(FrsFragment frsFragment) {
        this.bGF = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.hGQ = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bGF = UtilHelper.getStatusBarHeight();
        }
    }

    public void caU() {
        if (this.hJa && this.hJb >= 0) {
            vd(this.hJb);
        }
        this.hJa = false;
    }

    public void vc(int i) {
        if (i >= 0) {
            nF(true);
            ve(i);
            return;
        }
        nF(false);
        ve(i);
    }

    private void vd(int i) {
        FrameLayout frameLayout;
        String string;
        n bUT = this.hGQ.bUT();
        if (bUT != null && bUT.getListView() != null && (frameLayout = (FrameLayout) bUT.bWp()) != null) {
            if (this.hBf == null && this.hGQ.getPageContext() != null) {
                this.hBf = new TextView(this.hGQ.getPageContext().getPageActivity());
                this.hBf.setTextSize(0, this.hGQ.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.hBf.setGravity(17);
            }
            if (this.hBf != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.hBf.setText(string);
            }
            am.setBackgroundResource(this.hBf, R.color.cp_link_tip_a);
            am.setViewTextColor(this.hBf, (int) R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.hGj == null) {
                this.hGj = new aw();
            }
            this.hGj.a(this.hBf, frameLayout, layoutParams, 2000);
            this.hJb = -1;
        }
    }

    public void nF(boolean z) {
        this.hJa = z;
    }

    public void ve(int i) {
        this.hJb = i;
    }

    public void onDestroy() {
        if (this.hGj != null) {
            this.hGj.onDestroy();
        }
    }
}
