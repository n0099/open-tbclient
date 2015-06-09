package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.tbadkCore.FrsOfficalBanner;
/* loaded from: classes.dex */
class b implements com.baidu.adp.widget.ListView.z {
    final /* synthetic */ FrsActivity aLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsActivity frsActivity) {
        this.aLY = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.z
    public void T(boolean z) {
        boolean z2;
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        com.baidu.tieba.frs.c.a aVar;
        com.baidu.tieba.frs.c.a aVar2;
        z2 = this.aLY.aLl;
        if (z2) {
            bfVar = this.aLY.aLj;
            BdListView listView = bfVar.getListView();
            bfVar2 = this.aLY.aLj;
            FrsOfficalBanner LB = bfVar2.LB();
            int i = -1;
            if (listView.getFirstVisiblePosition() == 0 && listView.getChildCount() > 0 && (i = listView.getChildAt(0).getTop()) > (-LB.getHeight()) && i != 0) {
                aVar2 = this.aLY.aLB;
                aVar2.Mg();
            }
            if (i != 0 && !z) {
                bfVar3 = this.aLY.aLj;
                if (!bfVar3.KG() && listView.np()) {
                    LB.setVisibility(0);
                    aVar = this.aLY.aLB;
                    aVar.Mg();
                }
            }
        }
    }
}
