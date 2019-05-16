package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.k;
/* loaded from: classes4.dex */
public class a {
    private aq dqo;
    private TextView fBl;
    private final FrsFragment fGZ;
    private boolean fJb;
    private int fJc = -1;
    private int faF;

    public a(FrsFragment frsFragment) {
        this.faF = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.fGZ = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.faF = UtilHelper.getStatusBarHeight();
        }
    }

    public void bpv() {
        if (this.fJb && this.fJc >= 0) {
            sk(this.fJc);
        }
        this.fJb = false;
    }

    public void sj(int i) {
        if (i >= 0) {
            kA(true);
            sl(i);
            return;
        }
        kA(false);
        sl(i);
    }

    private void sk(int i) {
        FrameLayout frameLayout;
        String string;
        k bjM = this.fGZ.bjM();
        if (bjM != null && bjM.getListView() != null && (frameLayout = (FrameLayout) bjM.blb()) != null) {
            if (this.fBl == null && this.fGZ.getPageContext() != null) {
                this.fBl = new TextView(this.fGZ.getPageContext().getPageActivity());
                this.fBl.setTextSize(0, this.fGZ.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.fBl.setGravity(17);
            }
            if (this.fBl != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.fBl.setText(string);
            }
            al.k(this.fBl, R.color.cp_link_tip_a);
            al.j(this.fBl, R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.dqo == null) {
                this.dqo = new aq();
            }
            this.dqo.a(this.fBl, frameLayout, layoutParams, 2000);
            this.fJc = -1;
        }
    }

    public void kA(boolean z) {
        this.fJb = z;
    }

    public void sl(int i) {
        this.fJc = i;
    }

    public void onDestroy() {
        if (this.dqo != null) {
            this.dqo.onDestroy();
        }
    }
}
