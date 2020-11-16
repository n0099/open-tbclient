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
/* loaded from: classes21.dex */
public class a {
    private int cso;
    private TextView iXB;
    private final FrsFragment jdH;
    private be jda;
    private boolean jfM;
    private int jfN = -1;

    public a(FrsFragment frsFragment) {
        this.cso = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.jdH = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cso = UtilHelper.getStatusBarHeight();
        }
    }

    public void cEq() {
        if (this.jfM && this.jfN >= 0) {
            AC(this.jfN);
        }
        this.jfM = false;
    }

    public void AB(int i) {
        if (i >= 0) {
            qr(true);
            AD(i);
            return;
        }
        qr(false);
        AD(i);
    }

    private void AC(int i) {
        FrameLayout frameLayout;
        String string;
        q cxO = this.jdH.cxO();
        if (cxO != null && cxO.getListView() != null && (frameLayout = (FrameLayout) cxO.czo()) != null) {
            if (this.iXB == null && this.jdH.getPageContext() != null) {
                this.iXB = new TextView(this.jdH.getPageContext().getPageActivity());
                this.iXB.setTextSize(0, this.jdH.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.iXB.setGravity(17);
            }
            if (this.iXB != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.iXB.setText(string);
            }
            ap.setBackgroundResource(this.iXB, R.color.CAM_X0302);
            ap.setViewTextColor(this.iXB, R.color.CAM_X0112);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.jda == null) {
                this.jda = new be();
            }
            this.jda.a(this.iXB, frameLayout, layoutParams, 2000);
            this.jfN = -1;
        }
    }

    public void qr(boolean z) {
        this.jfM = z;
    }

    public void AD(int i) {
        this.jfN = i;
    }

    public void onDestroy() {
        if (this.jda != null) {
            this.jda.onDestroy();
        }
    }
}
