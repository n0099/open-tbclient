package com.baidu.tieba.enterForum.d;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g aWj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aWj = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.c.g gVar;
        e eVar2;
        com.baidu.tieba.enterForum.c.g gVar2;
        e eVar3;
        BdListView bdListView;
        eVar = this.aWj.aWh;
        gVar = eVar.aWc;
        if (gVar.KE() != null) {
            eVar2 = this.aWj.aWh;
            gVar2 = eVar2.aWc;
            gVar2.KE().setVisibility(0);
            eVar3 = this.aWj.aWh;
            bdListView = eVar3.aRC;
            bdListView.setVisibility(8);
        }
    }
}
