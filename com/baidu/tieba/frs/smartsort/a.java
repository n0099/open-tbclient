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
    private int cua;
    private TextView iWP;
    private final FrsFragment jcU;
    private be jcn;
    private boolean jfb;
    private int jfc = -1;

    public a(FrsFragment frsFragment) {
        this.cua = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.jcU = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cua = UtilHelper.getStatusBarHeight();
        }
    }

    public void cEL() {
        if (this.jfb && this.jfc >= 0) {
            Ae(this.jfc);
        }
        this.jfb = false;
    }

    public void Ad(int i) {
        if (i >= 0) {
            qo(true);
            Af(i);
            return;
        }
        qo(false);
        Af(i);
    }

    private void Ae(int i) {
        FrameLayout frameLayout;
        String string;
        q cyl = this.jcU.cyl();
        if (cyl != null && cyl.getListView() != null && (frameLayout = (FrameLayout) cyl.czL()) != null) {
            if (this.iWP == null && this.jcU.getPageContext() != null) {
                this.iWP = new TextView(this.jcU.getPageContext().getPageActivity());
                this.iWP.setTextSize(0, this.jcU.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.iWP.setGravity(17);
            }
            if (this.iWP != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.iWP.setText(string);
            }
            ap.setBackgroundResource(this.iWP, R.color.cp_link_tip_a);
            ap.setViewTextColor(this.iWP, R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.jcn == null) {
                this.jcn = new be();
            }
            this.jcn.a(this.iWP, frameLayout, layoutParams, 2000);
            this.jfc = -1;
        }
    }

    public void qo(boolean z) {
        this.jfb = z;
    }

    public void Af(int i) {
        this.jfc = i;
    }

    public void onDestroy() {
        if (this.jcn != null) {
            this.jcn.onDestroy();
        }
    }
}
