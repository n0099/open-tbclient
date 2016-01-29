package com.baidu.tieba.enterForum.d;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g aYx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aYx = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.c.g gVar;
        e eVar2;
        com.baidu.tieba.enterForum.c.g gVar2;
        e eVar3;
        BdListView bdListView;
        eVar = this.aYx.aYv;
        gVar = eVar.aYq;
        if (gVar.Mv() != null) {
            eVar2 = this.aYx.aYv;
            gVar2 = eVar2.aYq;
            gVar2.Mv().setVisibility(0);
            eVar3 = this.aYx.aYv;
            bdListView = eVar3.aYm;
            bdListView.setVisibility(8);
        }
    }
}
