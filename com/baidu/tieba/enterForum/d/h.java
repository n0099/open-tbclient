package com.baidu.tieba.enterForum.d;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g aGc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aGc = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.c.i iVar;
        e eVar2;
        com.baidu.tieba.enterForum.c.i iVar2;
        e eVar3;
        BdListView bdListView;
        eVar = this.aGc.aGa;
        iVar = eVar.aFU;
        if (iVar.Ik() != null) {
            eVar2 = this.aGc.aGa;
            iVar2 = eVar2.aFU;
            iVar2.Ik().setVisibility(0);
            eVar3 = this.aGc.aGa;
            bdListView = eVar3.aDC;
            bdListView.setVisibility(8);
        }
    }
}
