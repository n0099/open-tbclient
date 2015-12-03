package com.baidu.tieba.enterForum.d;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g aSh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aSh = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.c.g gVar;
        e eVar2;
        com.baidu.tieba.enterForum.c.g gVar2;
        e eVar3;
        BdListView bdListView;
        eVar = this.aSh.aSf;
        gVar = eVar.aSa;
        if (gVar.Kl() != null) {
            eVar2 = this.aSh.aSf;
            gVar2 = eVar2.aSa;
            gVar2.Kl().setVisibility(0);
            eVar3 = this.aSh.aSf;
            bdListView = eVar3.aNK;
            bdListView.setVisibility(8);
        }
    }
}
