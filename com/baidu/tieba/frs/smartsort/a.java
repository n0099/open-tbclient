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
    private int cDn;
    private TextView jAy;
    private bb jFX;
    private final FrsFragment jGE;
    private boolean jIH;
    private int jII = -1;

    public a(FrsFragment frsFragment) {
        this.cDn = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.jGE = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cDn = UtilHelper.getStatusBarHeight();
        }
    }

    public void cKn() {
        if (this.jIH && this.jII >= 0) {
            Ah(this.jII);
        }
        this.jIH = false;
    }

    public void Ag(int i) {
        if (i >= 0) {
            rw(true);
            Ai(i);
            return;
        }
        rw(false);
        Ai(i);
    }

    private void Ah(int i) {
        FrameLayout frameLayout;
        String string;
        q cCH = this.jGE.cCH();
        if (cCH != null && cCH.getListView() != null && (frameLayout = (FrameLayout) cCH.cEi()) != null) {
            if (this.jAy == null && this.jGE.getPageContext() != null) {
                this.jAy = new TextView(this.jGE.getPageContext().getPageActivity());
                this.jAy.setTextSize(0, this.jGE.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.jAy.setGravity(17);
            }
            if (this.jAy != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.jAy.setText(string);
            }
            ap.setBackgroundResource(this.jAy, R.color.CAM_X0302);
            ap.setViewTextColor(this.jAy, R.color.CAM_X0112);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.jFX == null) {
                this.jFX = new bb();
            }
            this.jFX.a(this.jAy, frameLayout, layoutParams, 2000);
            this.jII = -1;
        }
    }

    public void rw(boolean z) {
        this.jIH = z;
    }

    public void Ai(int i) {
        this.jII = i;
    }

    public void onDestroy() {
        if (this.jFX != null) {
            this.jFX.onDestroy();
        }
    }
}
