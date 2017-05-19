package com.baidu.tieba.enterForum.c;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g bHR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bHR = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        com.baidu.tieba.enterForum.model.d dVar;
        c cVar2;
        com.baidu.tieba.enterForum.model.d dVar2;
        c cVar3;
        BdListView bdListView;
        cVar = this.bHR.bHP;
        dVar = cVar.bHG;
        if (dVar.WE() != null) {
            cVar2 = this.bHR.bHP;
            dVar2 = cVar2.bHG;
            dVar2.WE().setVisibility(0);
            cVar3 = this.bHR.bHP;
            bdListView = cVar3.bkP;
            bdListView.setVisibility(8);
        }
    }
}
