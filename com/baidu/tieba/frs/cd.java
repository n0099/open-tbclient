package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.view.FrsOfficalBanner;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements com.baidu.adp.widget.ListView.ac {
    final /* synthetic */ bu aDt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bu buVar) {
        this.aDt = buVar;
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
        z2 = this.aDt.aDj;
        if (z2) {
            int i = -1;
            bdTypeListView = this.aDt.aCB;
            if (bdTypeListView.getFirstVisiblePosition() == 0) {
                bdTypeListView3 = this.aDt.aCB;
                if (bdTypeListView3.getChildCount() > 0) {
                    bdTypeListView4 = this.aDt.aCB;
                    i = bdTypeListView4.getChildAt(0).getTop();
                    frsOfficalBanner2 = this.aDt.aDi;
                    if (i > (-frsOfficalBanner2.getHeight()) && i != 0) {
                        rVar2 = this.aDt.aCF;
                        rVar2.Ha();
                    }
                }
            }
            if (i != 0 && !z) {
                z3 = this.aDt.aCu;
                if (!z3) {
                    bdTypeListView2 = this.aDt.aCB;
                    if (bdTypeListView2.hP()) {
                        frsOfficalBanner = this.aDt.aDi;
                        frsOfficalBanner.setVisibility(0);
                        rVar = this.aDt.aCF;
                        rVar.Ha();
                    }
                }
            }
        }
    }
}
