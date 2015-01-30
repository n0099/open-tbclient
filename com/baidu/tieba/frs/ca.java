package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.FrsOfficalBanner;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements com.baidu.adp.widget.ListView.ad {
    final /* synthetic */ bp aGj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bp bpVar) {
        this.aGj = bpVar;
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
        z2 = this.aGj.aFW;
        if (z2) {
            int i = -1;
            bdTypeListView = this.aGj.aFo;
            if (bdTypeListView.getFirstVisiblePosition() == 0) {
                bdTypeListView3 = this.aGj.aFo;
                if (bdTypeListView3.getChildCount() > 0) {
                    bdTypeListView4 = this.aGj.aFo;
                    i = bdTypeListView4.getChildAt(0).getTop();
                    frsOfficalBanner2 = this.aGj.aFV;
                    if (i > (-frsOfficalBanner2.getHeight()) && i != 0) {
                        oVar2 = this.aGj.aFt;
                        oVar2.HI();
                    }
                }
            }
            if (i != 0 && !z) {
                z3 = this.aGj.aFh;
                if (!z3) {
                    bdTypeListView2 = this.aGj.aFo;
                    if (bdTypeListView2.jK()) {
                        frsOfficalBanner = this.aGj.aFV;
                        frsOfficalBanner.setVisibility(0);
                        oVar = this.aGj.aFt;
                        oVar.HI();
                    }
                }
            }
        }
    }
}
