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
    private TextView jlc;
    private be jqF;
    private final FrsFragment jrm;
    private boolean jtr;
    private int jts = -1;

    public a(FrsFragment frsFragment) {
        this.czk = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.jrm = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.czk = UtilHelper.getStatusBarHeight();
        }
    }

    public void cJE() {
        if (this.jtr && this.jts >= 0) {
            Bq(this.jts);
        }
        this.jtr = false;
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
        q cCf = this.jrm.cCf();
        if (cCf != null && cCf.getListView() != null && (frameLayout = (FrameLayout) cCf.cDG()) != null) {
            if (this.jlc == null && this.jrm.getPageContext() != null) {
                this.jlc = new TextView(this.jrm.getPageContext().getPageActivity());
                this.jlc.setTextSize(0, this.jrm.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.jlc.setGravity(17);
            }
            if (this.jlc != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.jlc.setText(string);
            }
            ap.setBackgroundResource(this.jlc, R.color.CAM_X0302);
            ap.setViewTextColor(this.jlc, R.color.CAM_X0112);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.jqF == null) {
                this.jqF = new be();
            }
            this.jqF.a(this.jlc, frameLayout, layoutParams, 2000);
            this.jts = -1;
        }
    }

    public void qS(boolean z) {
        this.jtr = z;
    }

    public void Br(int i) {
        this.jts = i;
    }

    public void onDestroy() {
        if (this.jqF != null) {
            this.jqF.onDestroy();
        }
    }
}
