package com.baidu.tieba.enterForum.d;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g aNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aNP = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.c.g gVar;
        e eVar2;
        com.baidu.tieba.enterForum.c.g gVar2;
        e eVar3;
        BdListView bdListView;
        eVar = this.aNP.aNN;
        gVar = eVar.aNG;
        if (gVar.IL() != null) {
            eVar2 = this.aNP.aNN;
            gVar2 = eVar2.aNG;
            gVar2.IL().setVisibility(0);
            eVar3 = this.aNP.aNN;
            bdListView = eVar3.aLm;
            bdListView.setVisibility(8);
        }
    }
}
