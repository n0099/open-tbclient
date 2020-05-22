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
    private TextView hAs;
    private aw hFw;
    private final FrsFragment hGd;
    private boolean hIn;
    private int hIo = -1;

    public a(FrsFragment frsFragment) {
        this.bGF = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.hGd = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bGF = UtilHelper.getStatusBarHeight();
        }
    }

    public void caM() {
        if (this.hIn && this.hIo >= 0) {
            vb(this.hIo);
        }
        this.hIn = false;
    }

    public void va(int i) {
        if (i >= 0) {
            nF(true);
            vc(i);
            return;
        }
        nF(false);
        vc(i);
    }

    private void vb(int i) {
        FrameLayout frameLayout;
        String string;
        n bUR = this.hGd.bUR();
        if (bUR != null && bUR.getListView() != null && (frameLayout = (FrameLayout) bUR.bWn()) != null) {
            if (this.hAs == null && this.hGd.getPageContext() != null) {
                this.hAs = new TextView(this.hGd.getPageContext().getPageActivity());
                this.hAs.setTextSize(0, this.hGd.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.hAs.setGravity(17);
            }
            if (this.hAs != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.hAs.setText(string);
            }
            am.setBackgroundResource(this.hAs, R.color.cp_link_tip_a);
            am.setViewTextColor(this.hAs, (int) R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.hFw == null) {
                this.hFw = new aw();
            }
            this.hFw.a(this.hAs, frameLayout, layoutParams, 2000);
            this.hIo = -1;
        }
    }

    public void nF(boolean z) {
        this.hIn = z;
    }

    public void vc(int i) {
        this.hIo = i;
    }

    public void onDestroy() {
        if (this.hFw != null) {
            this.hFw.onDestroy();
        }
    }
}
