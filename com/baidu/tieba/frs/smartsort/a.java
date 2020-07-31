package com.baidu.tieba.frs.smartsort;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.frs.p;
/* loaded from: classes16.dex */
public class a {
    private int bLP;
    private TextView hUm;
    private bc hZv;
    private final FrsFragment iac;
    private boolean ick;
    private int icl = -1;

    public a(FrsFragment frsFragment) {
        this.bLP = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.iac = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bLP = UtilHelper.getStatusBarHeight();
        }
    }

    public void chM() {
        if (this.ick && this.icl >= 0) {
            wa(this.icl);
        }
        this.ick = false;
    }

    public void vZ(int i) {
        if (i >= 0) {
            ow(true);
            wb(i);
            return;
        }
        ow(false);
        wb(i);
    }

    private void wa(int i) {
        FrameLayout frameLayout;
        String string;
        p cbw = this.iac.cbw();
        if (cbw != null && cbw.getListView() != null && (frameLayout = (FrameLayout) cbw.ccV()) != null) {
            if (this.hUm == null && this.iac.getPageContext() != null) {
                this.hUm = new TextView(this.iac.getPageContext().getPageActivity());
                this.hUm.setTextSize(0, this.iac.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.hUm.setGravity(17);
            }
            if (this.hUm != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.hUm.setText(string);
            }
            ao.setBackgroundResource(this.hUm, R.color.cp_link_tip_a);
            ao.setViewTextColor(this.hUm, R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.hZv == null) {
                this.hZv = new bc();
            }
            this.hZv.a(this.hUm, frameLayout, layoutParams, 2000);
            this.icl = -1;
        }
    }

    public void ow(boolean z) {
        this.ick = z;
    }

    public void wb(int i) {
        this.icl = i;
    }

    public void onDestroy() {
        if (this.hZv != null) {
            this.hZv.onDestroy();
        }
    }
}
