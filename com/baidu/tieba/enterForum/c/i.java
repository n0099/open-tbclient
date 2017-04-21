package com.baidu.tieba.enterForum.c;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ h bIi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bIi = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.model.e eVar2;
        e eVar3;
        com.baidu.tieba.enterForum.model.e eVar4;
        e eVar5;
        BdListView bdListView;
        eVar = this.bIi.bIg;
        eVar2 = eVar.bHZ;
        if (eVar2.Xq() != null) {
            eVar3 = this.bIi.bIg;
            eVar4 = eVar3.bHZ;
            eVar4.Xq().setVisibility(0);
            eVar5 = this.bIi.bIg;
            bdListView = eVar5.bks;
            bdListView.setVisibility(8);
        }
    }
}
