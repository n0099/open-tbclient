package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.FrsOfficalBanner;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements com.baidu.adp.widget.ListView.ad {
    final /* synthetic */ bq aFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(bq bqVar) {
        this.aFg = bqVar;
    }

    @Override // com.baidu.adp.widget.ListView.ad
    public void T(boolean z) {
        boolean z2;
        BdTypeListView bdTypeListView;
        boolean z3;
        BdTypeListView bdTypeListView2;
        FrsOfficalBanner frsOfficalBanner;
        com.baidu.tieba.frs.view.o oVar;
        BdTypeListView bdTypeListView3;
        BdTypeListView bdTypeListView4;
        FrsOfficalBanner frsOfficalBanner2;
        com.baidu.tieba.frs.view.o oVar2;
        z2 = this.aFg.aET;
        if (z2) {
            int i = -1;
            bdTypeListView = this.aFg.aEm;
            if (bdTypeListView.getFirstVisiblePosition() == 0) {
                bdTypeListView3 = this.aFg.aEm;
                if (bdTypeListView3.getChildCount() > 0) {
                    bdTypeListView4 = this.aFg.aEm;
                    i = bdTypeListView4.getChildAt(0).getTop();
                    frsOfficalBanner2 = this.aFg.aES;
                    if (i > (-frsOfficalBanner2.getHeight()) && i != 0) {
                        oVar2 = this.aFg.aEq;
                        oVar2.Hk();
                    }
                }
            }
            if (i != 0 && !z) {
                z3 = this.aFg.aEf;
                if (!z3) {
                    bdTypeListView2 = this.aFg.aEm;
                    if (bdTypeListView2.jL()) {
                        frsOfficalBanner = this.aFg.aES;
                        frsOfficalBanner.setVisibility(0);
                        oVar = this.aFg.aEq;
                        oVar.Hk();
                    }
                }
            }
        }
    }
}
