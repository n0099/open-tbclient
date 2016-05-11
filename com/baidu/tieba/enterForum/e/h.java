package com.baidu.tieba.enterForum.e;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g aYO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aYO = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.c.g gVar;
        e eVar2;
        com.baidu.tieba.enterForum.c.g gVar2;
        e eVar3;
        BdListView bdListView;
        eVar = this.aYO.aYM;
        gVar = eVar.aYD;
        if (gVar.MW() != null) {
            eVar2 = this.aYO.aYM;
            gVar2 = eVar2.aYD;
            gVar2.MW().setVisibility(0);
            eVar3 = this.aYO.aYM;
            bdListView = eVar3.aYz;
            bdListView.setVisibility(8);
        }
    }
}
