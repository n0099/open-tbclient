package com.baidu.tieba.enterForum.e;

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
        com.baidu.tieba.enterForum.c.f fVar;
        e eVar2;
        com.baidu.tieba.enterForum.c.f fVar2;
        e eVar3;
        BdListView bdListView;
        eVar = this.bIi.bIg;
        fVar = eVar.bHX;
        if (fVar.XS() != null) {
            eVar2 = this.bIi.bIg;
            fVar2 = eVar2.bHX;
            fVar2.XS().setVisibility(0);
            eVar3 = this.bIi.bIg;
            bdListView = eVar3.bHT;
            bdListView.setVisibility(8);
        }
    }
}
