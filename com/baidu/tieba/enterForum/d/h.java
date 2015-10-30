package com.baidu.tieba.enterForum.d;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g aMU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aMU = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.c.g gVar;
        e eVar2;
        com.baidu.tieba.enterForum.c.g gVar2;
        e eVar3;
        BdListView bdListView;
        eVar = this.aMU.aMS;
        gVar = eVar.aMM;
        if (gVar.ID() != null) {
            eVar2 = this.aMU.aMS;
            gVar2 = eVar2.aMM;
            gVar2.ID().setVisibility(0);
            eVar3 = this.aMU.aMS;
            bdListView = eVar3.aKp;
            bdListView.setVisibility(8);
        }
    }
}
