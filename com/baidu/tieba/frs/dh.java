package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.view.FrsOfficalBanner;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dh implements com.baidu.adp.widget.ListView.y {
    final /* synthetic */ cv a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(cv cvVar) {
        this.a = cvVar;
    }

    @Override // com.baidu.adp.widget.ListView.y
    public void a(boolean z) {
        boolean z2;
        BdListView bdListView;
        FrsOfficalBanner frsOfficalBanner;
        boolean z3;
        BdListView bdListView2;
        FrsOfficalBanner frsOfficalBanner2;
        com.baidu.tieba.frs.view.n nVar;
        BdListView bdListView3;
        BdListView bdListView4;
        FrsOfficalBanner frsOfficalBanner3;
        com.baidu.tieba.frs.view.n nVar2;
        com.baidu.tieba.frs.view.n nVar3;
        z2 = this.a.ar;
        if (z2) {
            int i = -1;
            bdListView = this.a.s;
            if (bdListView.getFirstVisiblePosition() == 0) {
                bdListView3 = this.a.s;
                if (bdListView3.getChildCount() > 0) {
                    bdListView4 = this.a.s;
                    i = bdListView4.getChildAt(0).getTop();
                    frsOfficalBanner3 = this.a.aq;
                    if (i <= (-frsOfficalBanner3.getHeight()) || i == 0) {
                        nVar2 = this.a.B;
                        nVar2.a();
                    } else {
                        nVar3 = this.a.B;
                        nVar3.b();
                    }
                }
            }
            if (i != 0 && !z) {
                z3 = this.a.i;
                if (!z3) {
                    bdListView2 = this.a.s;
                    if (bdListView2.f()) {
                        frsOfficalBanner2 = this.a.aq;
                        frsOfficalBanner2.setVisibility(0);
                        nVar = this.a.B;
                        nVar.b();
                        return;
                    }
                }
            }
            frsOfficalBanner = this.a.aq;
            frsOfficalBanner.setVisibility(8);
        }
    }
}
