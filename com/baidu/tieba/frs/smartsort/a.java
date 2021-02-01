package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.frs.q;
/* loaded from: classes2.dex */
public class a {
    private int cBN;
    private final FrsFragment jEH;
    private bb jEa;
    private boolean jGK;
    private int jGL = -1;
    private TextView jyB;

    public a(FrsFragment frsFragment) {
        this.cBN = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.jEH = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cBN = UtilHelper.getStatusBarHeight();
        }
    }

    public void cKa() {
        if (this.jGK && this.jGL >= 0) {
            Ag(this.jGL);
        }
        this.jGK = false;
    }

    public void Af(int i) {
        if (i >= 0) {
            rw(true);
            Ah(i);
            return;
        }
        rw(false);
        Ah(i);
    }

    private void Ag(int i) {
        FrameLayout frameLayout;
        String string;
        q cCu = this.jEH.cCu();
        if (cCu != null && cCu.getListView() != null && (frameLayout = (FrameLayout) cCu.cDV()) != null) {
            if (this.jyB == null && this.jEH.getPageContext() != null) {
                this.jyB = new TextView(this.jEH.getPageContext().getPageActivity());
                this.jyB.setTextSize(0, this.jEH.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.jyB.setGravity(17);
            }
            if (this.jyB != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.jyB.setText(string);
            }
            ap.setBackgroundResource(this.jyB, R.color.CAM_X0302);
            ap.setViewTextColor(this.jyB, R.color.CAM_X0112);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.jEa == null) {
                this.jEa = new bb();
            }
            this.jEa.a(this.jyB, frameLayout, layoutParams, 2000);
            this.jGL = -1;
        }
    }

    public void rw(boolean z) {
        this.jGK = z;
    }

    public void Ah(int i) {
        this.jGL = i;
    }

    public void onDestroy() {
        if (this.jEa != null) {
            this.jEa.onDestroy();
        }
    }
}
