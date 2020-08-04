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
    private TextView hUo;
    private bc hZx;
    private final FrsFragment iae;
    private boolean icm;
    private int icn = -1;

    public a(FrsFragment frsFragment) {
        this.bLP = 0;
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.iae = frsFragment;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bLP = UtilHelper.getStatusBarHeight();
        }
    }

    public void chM() {
        if (this.icm && this.icn >= 0) {
            wa(this.icn);
        }
        this.icm = false;
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
        p cbw = this.iae.cbw();
        if (cbw != null && cbw.getListView() != null && (frameLayout = (FrameLayout) cbw.ccV()) != null) {
            if (this.hUo == null && this.iae.getPageContext() != null) {
                this.hUo = new TextView(this.iae.getPageContext().getPageActivity());
                this.hUo.setTextSize(0, this.iae.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.hUo.setGravity(17);
            }
            if (this.hUo != null) {
                if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
                }
                this.hUo.setText(string);
            }
            ao.setBackgroundResource(this.hUo, R.color.cp_link_tip_a);
            ao.setViewTextColor(this.hUo, R.color.cp_cont_i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.hZx == null) {
                this.hZx = new bc();
            }
            this.hZx.a(this.hUo, frameLayout, layoutParams, 2000);
            this.icn = -1;
        }
    }

    public void ow(boolean z) {
        this.icm = z;
    }

    public void wb(int i) {
        this.icn = i;
    }

    public void onDestroy() {
        if (this.hZx != null) {
            this.hZx.onDestroy();
        }
    }
}
