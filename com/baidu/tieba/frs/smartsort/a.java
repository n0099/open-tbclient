package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.frs.p;
/* loaded from: classes9.dex */
public class a {
    private int bLt;
    private TextView hOn;
    private bc hTw;
    private final FrsFragment hUd;
    private boolean hWm;
    private int hWn = -1;

    public a(FrsFragment frsFragment) {
        this.bLt = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.hUd = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bLt = UtilHelper.getStatusBarHeight();
        }
    }

    public void cen() {
        if (this.hWm && this.hWn >= 0) {
            vI(this.hWn);
        }
        this.hWm = false;
    }

    public void vH(int i) {
        if (i >= 0) {
            nR(true);
            vJ(i);
            return;
        }
        nR(false);
        vJ(i);
    }

    private void vI(int i) {
        FrameLayout frameLayout;
        String string;
        p bYa = this.hUd.bYa();
        if (bYa != null && bYa.getListView() != null && (frameLayout = (FrameLayout) bYa.bZy()) != null) {
            if (this.hOn == null && this.hUd.getPageContext() != null) {
                this.hOn = new TextView(this.hUd.getPageContext().getPageActivity());
                this.hOn.setTextSize(0, this.hUd.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.hOn.setGravity(17);
            }
            if (this.hOn != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.hOn.setText(string);
            }
            an.setBackgroundResource(this.hOn, R.color.cp_link_tip_a);
            an.setViewTextColor(this.hOn, (int) R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.hTw == null) {
                this.hTw = new bc();
            }
            this.hTw.a(this.hOn, frameLayout, layoutParams, 2000);
            this.hWn = -1;
        }
    }

    public void nR(boolean z) {
        this.hWm = z;
    }

    public void vJ(int i) {
        this.hWn = i;
    }

    public void onDestroy() {
        if (this.hTw != null) {
            this.hTw.onDestroy();
        }
    }
}
