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
    private int bTp;
    private TextView ipD;
    private final FrsFragment ivI;
    private be ivb;
    private boolean ixP;
    private int ixQ = -1;

    public a(FrsFragment frsFragment) {
        this.bTp = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.ivI = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bTp = UtilHelper.getStatusBarHeight();
        }
    }

    public void cvG() {
        if (this.ixP && this.ixQ >= 0) {
            yS(this.ixQ);
        }
        this.ixP = false;
    }

    public void yR(int i) {
        if (i >= 0) {
            pi(true);
            yT(i);
            return;
        }
        pi(false);
        yT(i);
    }

    private void yS(int i) {
        FrameLayout frameLayout;
        String string;
        q cpf = this.ivI.cpf();
        if (cpf != null && cpf.getListView() != null && (frameLayout = (FrameLayout) cpf.cqF()) != null) {
            if (this.ipD == null && this.ivI.getPageContext() != null) {
                this.ipD = new TextView(this.ivI.getPageContext().getPageActivity());
                this.ipD.setTextSize(0, this.ivI.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.ipD.setGravity(17);
            }
            if (this.ipD != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.ipD.setText(string);
            }
            ap.setBackgroundResource(this.ipD, R.color.cp_link_tip_a);
            ap.setViewTextColor(this.ipD, R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.ivb == null) {
                this.ivb = new be();
            }
            this.ivb.a(this.ipD, frameLayout, layoutParams, 2000);
            this.ixQ = -1;
        }
    }

    public void pi(boolean z) {
        this.ixP = z;
    }

    public void yT(int i) {
        this.ixQ = i;
    }

    public void onDestroy() {
        if (this.ivb != null) {
            this.ivb.onDestroy();
        }
    }
}
