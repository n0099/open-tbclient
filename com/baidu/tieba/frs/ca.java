package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.FrsOfficalBanner;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements com.baidu.adp.widget.ListView.ad {
    final /* synthetic */ bp aGg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bp bpVar) {
        this.aGg = bpVar;
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
        z2 = this.aGg.aFT;
        if (z2) {
            int i = -1;
            bdTypeListView = this.aGg.aFl;
            if (bdTypeListView.getFirstVisiblePosition() == 0) {
                bdTypeListView3 = this.aGg.aFl;
                if (bdTypeListView3.getChildCount() > 0) {
                    bdTypeListView4 = this.aGg.aFl;
                    i = bdTypeListView4.getChildAt(0).getTop();
                    frsOfficalBanner2 = this.aGg.aFS;
                    if (i > (-frsOfficalBanner2.getHeight()) && i != 0) {
                        oVar2 = this.aGg.aFq;
                        oVar2.HC();
                    }
                }
            }
            if (i != 0 && !z) {
                z3 = this.aGg.aFe;
                if (!z3) {
                    bdTypeListView2 = this.aGg.aFl;
                    if (bdTypeListView2.jD()) {
                        frsOfficalBanner = this.aGg.aFS;
                        frsOfficalBanner.setVisibility(0);
                        oVar = this.aGg.aFq;
                        oVar.HC();
                    }
                }
            }
        }
    }
}
