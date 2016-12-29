package com.baidu.tieba.enterForum.d;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ h brh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.brh = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.c.f fVar;
        e eVar2;
        com.baidu.tieba.enterForum.c.f fVar2;
        e eVar3;
        BdListView bdListView;
        eVar = this.brh.brf;
        fVar = eVar.bqX;
        if (fVar.TA() != null) {
            eVar2 = this.brh.brf;
            fVar2 = eVar2.bqX;
            fVar2.TA().setVisibility(0);
            eVar3 = this.brh.brf;
            bdListView = eVar3.bqT;
            bdListView.setVisibility(8);
        }
    }
}
