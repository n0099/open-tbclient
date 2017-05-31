package com.baidu.tieba.enterForum.c;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g bNF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bNF = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        com.baidu.tieba.enterForum.model.d dVar;
        c cVar2;
        com.baidu.tieba.enterForum.model.d dVar2;
        c cVar3;
        BdListView bdListView;
        cVar = this.bNF.bND;
        dVar = cVar.bNu;
        if (dVar.XH() != null) {
            cVar2 = this.bNF.bND;
            dVar2 = cVar2.bNu;
            dVar2.XH().setVisibility(0);
            cVar3 = this.bNF.bND;
            bdListView = cVar3.blW;
            bdListView.setVisibility(8);
        }
    }
}
