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
    private final FrsFragment jEV;
    private bb jEo;
    private boolean jGY;
    private int jGZ = -1;
    private TextView jyP;

    public a(FrsFragment frsFragment) {
        this.cBN = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.jEV = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cBN = UtilHelper.getStatusBarHeight();
        }
    }

    public void cKh() {
        if (this.jGY && this.jGZ >= 0) {
            Ag(this.jGZ);
        }
        this.jGY = false;
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
        q cCB = this.jEV.cCB();
        if (cCB != null && cCB.getListView() != null && (frameLayout = (FrameLayout) cCB.cEc()) != null) {
            if (this.jyP == null && this.jEV.getPageContext() != null) {
                this.jyP = new TextView(this.jEV.getPageContext().getPageActivity());
                this.jyP.setTextSize(0, this.jEV.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.jyP.setGravity(17);
            }
            if (this.jyP != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.jyP.setText(string);
            }
            ap.setBackgroundResource(this.jyP, R.color.CAM_X0302);
            ap.setViewTextColor(this.jyP, R.color.CAM_X0112);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.jEo == null) {
                this.jEo = new bb();
            }
            this.jEo.a(this.jyP, frameLayout, layoutParams, 2000);
            this.jGZ = -1;
        }
    }

    public void rw(boolean z) {
        this.jGY = z;
    }

    public void Ah(int i) {
        this.jGZ = i;
    }

    public void onDestroy() {
        if (this.jEo != null) {
            this.jEo.onDestroy();
        }
    }
}
