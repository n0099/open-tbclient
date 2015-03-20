package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.tbadkCore.FrsOfficalBanner;
/* loaded from: classes.dex */
class b implements com.baidu.adp.widget.ListView.z {
    final /* synthetic */ FrsActivity aJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsActivity frsActivity) {
        this.aJG = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.z
    public void R(boolean z) {
        boolean z2;
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        com.baidu.tieba.frs.c.a aVar;
        com.baidu.tieba.frs.c.a aVar2;
        z2 = this.aJG.aIU;
        if (z2) {
            bfVar = this.aJG.aIS;
            BdListView listView = bfVar.getListView();
            bfVar2 = this.aJG.aIS;
            FrsOfficalBanner Kn = bfVar2.Kn();
            int i = -1;
            if (listView.getFirstVisiblePosition() == 0 && listView.getChildCount() > 0 && (i = listView.getChildAt(0).getTop()) > (-Kn.getHeight()) && i != 0) {
                aVar2 = this.aJG.aJl;
                aVar2.KO();
            }
            if (i != 0 && !z) {
                bfVar3 = this.aJG.aIS;
                if (!bfVar3.Jv() && listView.mY()) {
                    Kn.setVisibility(0);
                    aVar = this.aJG.aJl;
                    aVar.KO();
                }
            }
        }
    }
}
