package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.view.FrsOfficalBanner;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements com.baidu.adp.widget.ListView.ac {
    final /* synthetic */ bu aDD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bu buVar) {
        this.aDD = buVar;
    }

    @Override // com.baidu.adp.widget.ListView.ac
    public void I(boolean z) {
        boolean z2;
        BdTypeListView bdTypeListView;
        boolean z3;
        BdTypeListView bdTypeListView2;
        FrsOfficalBanner frsOfficalBanner;
        com.baidu.tieba.frs.view.r rVar;
        BdTypeListView bdTypeListView3;
        BdTypeListView bdTypeListView4;
        FrsOfficalBanner frsOfficalBanner2;
        com.baidu.tieba.frs.view.r rVar2;
        z2 = this.aDD.aDt;
        if (z2) {
            int i = -1;
            bdTypeListView = this.aDD.aCL;
            if (bdTypeListView.getFirstVisiblePosition() == 0) {
                bdTypeListView3 = this.aDD.aCL;
                if (bdTypeListView3.getChildCount() > 0) {
                    bdTypeListView4 = this.aDD.aCL;
                    i = bdTypeListView4.getChildAt(0).getTop();
                    frsOfficalBanner2 = this.aDD.aDs;
                    if (i > (-frsOfficalBanner2.getHeight()) && i != 0) {
                        rVar2 = this.aDD.aCP;
                        rVar2.Hc();
                    }
                }
            }
            if (i != 0 && !z) {
                z3 = this.aDD.aCE;
                if (!z3) {
                    bdTypeListView2 = this.aDD.aCL;
                    if (bdTypeListView2.hP()) {
                        frsOfficalBanner = this.aDD.aDs;
                        frsOfficalBanner.setVisibility(0);
                        rVar = this.aDD.aCP;
                        rVar.Hc();
                    }
                }
            }
        }
    }
}
