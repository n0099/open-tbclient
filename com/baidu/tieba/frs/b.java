package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.tbadkCore.FrsOfficalBanner;
/* loaded from: classes.dex */
class b implements com.baidu.adp.widget.ListView.z {
    final /* synthetic */ FrsActivity aLX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsActivity frsActivity) {
        this.aLX = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.z
    public void T(boolean z) {
        boolean z2;
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        com.baidu.tieba.frs.c.a aVar;
        com.baidu.tieba.frs.c.a aVar2;
        z2 = this.aLX.aLk;
        if (z2) {
            bfVar = this.aLX.aLi;
            BdListView listView = bfVar.getListView();
            bfVar2 = this.aLX.aLi;
            FrsOfficalBanner LA = bfVar2.LA();
            int i = -1;
            if (listView.getFirstVisiblePosition() == 0 && listView.getChildCount() > 0 && (i = listView.getChildAt(0).getTop()) > (-LA.getHeight()) && i != 0) {
                aVar2 = this.aLX.aLA;
                aVar2.Mf();
            }
            if (i != 0 && !z) {
                bfVar3 = this.aLX.aLi;
                if (!bfVar3.KF() && listView.np()) {
                    LA.setVisibility(0);
                    aVar = this.aLX.aLA;
                    aVar.Mf();
                }
            }
        }
    }
}
