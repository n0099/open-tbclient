package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.tbadkCore.FrsOfficalBanner;
/* loaded from: classes.dex */
class b implements com.baidu.adp.widget.ListView.z {
    final /* synthetic */ FrsActivity aJQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsActivity frsActivity) {
        this.aJQ = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.z
    public void R(boolean z) {
        boolean z2;
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        com.baidu.tieba.frs.c.a aVar;
        com.baidu.tieba.frs.c.a aVar2;
        z2 = this.aJQ.aJc;
        if (z2) {
            bfVar = this.aJQ.aJa;
            BdListView listView = bfVar.getListView();
            bfVar2 = this.aJQ.aJa;
            FrsOfficalBanner Ku = bfVar2.Ku();
            int i = -1;
            if (listView.getFirstVisiblePosition() == 0 && listView.getChildCount() > 0 && (i = listView.getChildAt(0).getTop()) > (-Ku.getHeight()) && i != 0) {
                aVar2 = this.aJQ.aJt;
                aVar2.La();
            }
            if (i != 0 && !z) {
                bfVar3 = this.aJQ.aJa;
                if (!bfVar3.JB() && listView.mY()) {
                    Ku.setVisibility(0);
                    aVar = this.aJQ.aJt;
                    aVar.La();
                }
            }
        }
    }
}
