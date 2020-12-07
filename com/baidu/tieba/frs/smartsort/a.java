package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.frs.q;
/* loaded from: classes22.dex */
public class a {
    private int czk;
    private TextView jla;
    private be jqD;
    private final FrsFragment jrk;
    private boolean jtp;
    private int jtq = -1;

    public a(FrsFragment frsFragment) {
        this.czk = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.jrk = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.czk = UtilHelper.getStatusBarHeight();
        }
    }

    public void cJD() {
        if (this.jtp && this.jtq >= 0) {
            Bq(this.jtq);
        }
        this.jtp = false;
    }

    public void Bp(int i) {
        if (i >= 0) {
            qS(true);
            Br(i);
            return;
        }
        qS(false);
        Br(i);
    }

    private void Bq(int i) {
        FrameLayout frameLayout;
        String string;
        q cCe = this.jrk.cCe();
        if (cCe != null && cCe.getListView() != null && (frameLayout = (FrameLayout) cCe.cDF()) != null) {
            if (this.jla == null && this.jrk.getPageContext() != null) {
                this.jla = new TextView(this.jrk.getPageContext().getPageActivity());
                this.jla.setTextSize(0, this.jrk.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.jla.setGravity(17);
            }
            if (this.jla != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.jla.setText(string);
            }
            ap.setBackgroundResource(this.jla, R.color.CAM_X0302);
            ap.setViewTextColor(this.jla, R.color.CAM_X0112);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.jqD == null) {
                this.jqD = new be();
            }
            this.jqD.a(this.jla, frameLayout, layoutParams, 2000);
            this.jtq = -1;
        }
    }

    public void qS(boolean z) {
        this.jtp = z;
    }

    public void Br(int i) {
        this.jtq = i;
    }

    public void onDestroy() {
        if (this.jqD != null) {
            this.jqD.onDestroy();
        }
    }
}
