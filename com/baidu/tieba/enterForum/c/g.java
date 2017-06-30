package com.baidu.tieba.enterForum.c;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ f bUA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.bUA = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        com.baidu.tieba.enterForum.model.d dVar;
        c cVar2;
        com.baidu.tieba.enterForum.model.d dVar2;
        c cVar3;
        BdListView bdListView;
        cVar = this.bUA.bUy;
        dVar = cVar.bUo;
        if (dVar.abf() != null) {
            cVar2 = this.bUA.bUy;
            dVar2 = cVar2.bUo;
            dVar2.abf().setVisibility(0);
            cVar3 = this.bUA.bUy;
            bdListView = cVar3.bpM;
            bdListView.setVisibility(8);
        }
    }
}
