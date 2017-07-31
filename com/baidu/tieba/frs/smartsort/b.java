package com.baidu.tieba.frs.smartsort;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.i;
/* loaded from: classes.dex */
public class b {
    private ar beQ;
    private int cdA;

    /* renamed from: com  reason: collision with root package name */
    private final com.baidu.tieba.frs.f f7com;
    private TextView cul;
    private boolean cvv;
    private int cvw = -1;

    public b(com.baidu.tieba.frs.f fVar) {
        this.cdA = 0;
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is null");
        }
        this.f7com = fVar;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cdA = UtilHelper.getStatusBarHeight();
        }
    }

    public void aiS() {
        if (this.cvv && this.cvw >= 0) {
            ji(this.cvw);
        }
        this.cvv = false;
    }

    public void jh(int i) {
        if (i >= 0) {
            eZ(true);
            jj(i);
            return;
        }
        eZ(false);
        jj(i);
    }

    private void ji(int i) {
        String string;
        com.baidu.tieba.frs.entelechy.b.d aeX = this.f7com.aeX();
        i aeZ = this.f7com.aeZ();
        if (aeZ != null && aeX != null && aeX.ahb() != null && (aeZ.VR() instanceof NoPressedRelativeLayout)) {
            FrameLayout afY = aeZ.afY();
            if (this.cul == null || this.cul.getVisibility() != 0 || afY.getChildCount() < 1) {
                if (this.cul == null && this.f7com.getPageContext() != null) {
                    this.cul = new TextView(this.f7com.getPageContext().getPageActivity());
                    this.cul.setTextSize(0, this.f7com.getResources().getDimensionPixelSize(d.f.fontsize28));
                    this.cul.setGravity(17);
                }
                if (this.cul != null) {
                    if (i > 0) {
                        string = String.format(TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_return), Integer.valueOf(i));
                    } else {
                        string = TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_nodata);
                    }
                    this.cul.setText(string);
                }
                View ahb = aeX.ahb();
                BdTypeListView listView = aeZ.getListView();
                if (ahb != null && listView != null) {
                    ai.j(this.cul, d.e.common_color_10260);
                    ai.i(this.cul, d.e.cp_cont_g);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, k.g(TbadkCoreApplication.getInst(), d.f.ds56));
                    layoutParams.addRule(6, d.h.frs_list_content);
                    if (aeZ.afy() != null && aeZ.afy().getLayoutParams() != null) {
                        layoutParams.topMargin = aeZ.afy().getLayoutParams().height;
                    } else {
                        layoutParams.topMargin = 0;
                    }
                    if (this.beQ == null) {
                        this.beQ = new ar();
                    }
                    this.beQ.a(this.cul, afY, layoutParams, 2000);
                    this.cvw = -1;
                }
            }
        }
    }

    public void aiT() {
        if (this.cul != null && this.cul.getVisibility() == 0) {
            com.baidu.tieba.frs.entelechy.b.d aeX = this.f7com.aeX();
            i aeZ = this.f7com.aeZ();
            if (aeZ != null && aeX != null && aeX.ahb() != null && (aeZ.VR() instanceof NoPressedRelativeLayout)) {
                BdTypeListView listView = aeZ.getListView();
                View ahb = aeX.ahb();
                if (listView != null) {
                    boolean z = listView.indexOfChild(ahb) >= 0;
                    if (this.beQ != null && !z && this.cul.getTop() <= this.cdA) {
                        this.beQ.hideTip();
                    }
                }
            }
        }
    }

    public void eZ(boolean z) {
        this.cvv = z;
    }

    public void jj(int i) {
        this.cvw = i;
    }

    public void onDestroy() {
        if (this.beQ != null) {
            this.beQ.onDestroy();
        }
    }
}
