package com.baidu.tieba.enterForum.d;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g aDY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aDY = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.c.i iVar;
        e eVar2;
        com.baidu.tieba.enterForum.c.i iVar2;
        e eVar3;
        BdListView bdListView;
        eVar = this.aDY.aDX;
        iVar = eVar.aDS;
        if (iVar.Hj() != null) {
            eVar2 = this.aDY.aDX;
            iVar2 = eVar2.aDS;
            iVar2.Hj().setVisibility(0);
            eVar3 = this.aDY.aDX;
            bdListView = eVar3.aBF;
            bdListView.setVisibility(8);
        }
    }
}
