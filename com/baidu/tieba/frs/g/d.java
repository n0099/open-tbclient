package com.baidu.tieba.frs.g;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.cs;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class d {
    private int bOk;
    private final FrsActivity bZY;
    private cs cgU;
    private TextView cgV;
    private boolean cgW;
    private int cgX = -1;

    public d(FrsActivity frsActivity) {
        this.bOk = 0;
        if (frsActivity == null) {
            throw new NullPointerException("FrsActivity is null");
        }
        this.bZY = frsActivity;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bOk = UtilHelper.getStatusBarHeight();
        }
    }

    public void agO() {
        if (this.cgW && this.cgX >= 0) {
            iy(this.cgX);
        }
        this.cgW = false;
    }

    public void agP() {
        if (this.cgU != null) {
            this.cgU.hideTip();
        }
    }

    public void ix(int i) {
        if (i >= 0) {
            et(true);
            iz(i);
            return;
        }
        et(false);
        iz(i);
    }

    private void iy(int i) {
        String string;
        com.baidu.tieba.frs.entelechy.b.d abX = this.bZY.abX();
        au abZ = this.bZY.abZ();
        if (abZ != null && abX != null && abX.aeK() != null && (abZ.adf() instanceof NoPressedRelativeLayout)) {
            if (this.cgV == null) {
                this.cgV = new TextView(this.bZY.getPageContext().getPageActivity());
                this.cgV.setTextSize(0, this.bZY.getResources().getDimensionPixelSize(r.e.fontsize28));
                this.cgV.setGravity(17);
            }
            if (i > 0) {
                string = String.format(TbadkCoreApplication.m9getInst().getString(r.j.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.m9getInst().getString(r.j.recommend_frs_refresh_nodata);
            }
            this.cgV.setText(string);
            View aeK = abX.aeK();
            BdTypeListView acW = abZ.acW();
            if (aeK != null && acW != null) {
                int bottom = aeK.getBottom();
                at.k(this.cgV, r.d.common_color_10260);
                at.j((View) this.cgV, r.d.cp_cont_g);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, k.e(TbadkCoreApplication.m9getInst(), r.e.ds56));
                layoutParams.addRule(6);
                boolean z = abZ.acH() != null && (abZ.acH().getBottom() <= aeK.getTop() || abZ.acH().getVisibility() != 0);
                if (acW.indexOfChild(aeK) >= 0 && z) {
                    layoutParams.topMargin = bottom;
                    if (this.cgU == null) {
                        this.cgU = new cs();
                    }
                    this.cgU.a(this.cgV, (NoPressedRelativeLayout) abZ.adf(), layoutParams, 2000);
                }
                this.cgX = -1;
            }
        }
    }

    public void agQ() {
        if (this.cgV != null && this.cgV.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d abX = this.bZY.abX();
            au abZ = this.bZY.abZ();
            if (abZ != null && abX != null && abX.aeK() != null && (abZ.adf() instanceof NoPressedRelativeLayout)) {
                BdTypeListView acW = abZ.acW();
                View aeK = abX.aeK();
                if (acW != null) {
                    boolean z = acW.indexOfChild(aeK) >= 0;
                    if (this.cgV.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cgV.getLayoutParams();
                        if (z && aeK.getBottom() > this.bOk) {
                            layoutParams.topMargin = aeK.getBottom();
                        } else {
                            layoutParams.topMargin = this.bOk;
                        }
                        this.cgV.setLayoutParams(layoutParams);
                    }
                    if (this.cgU != null && !z && this.cgV.getTop() <= this.bOk) {
                        this.cgU.hideTip();
                    }
                }
            }
        }
    }

    public void et(boolean z) {
        this.cgW = z;
    }

    public void iz(int i) {
        this.cgX = i;
    }

    public void onDestroy() {
        if (this.cgU != null) {
            this.cgU.onDestroy();
        }
    }
}
