package com.baidu.tieba.enterForum.d;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g aNC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aNC = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.c.g gVar;
        e eVar2;
        com.baidu.tieba.enterForum.c.g gVar2;
        e eVar3;
        BdListView bdListView;
        eVar = this.aNC.aNA;
        gVar = eVar.aNt;
        if (gVar.IX() != null) {
            eVar2 = this.aNC.aNA;
            gVar2 = eVar2.aNt;
            gVar2.IX().setVisibility(0);
            eVar3 = this.aNC.aNA;
            bdListView = eVar3.aKZ;
            bdListView.setVisibility(8);
        }
    }
}
