package com.baidu.tieba.enterForum.d;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ h bIk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bIk = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.c.f fVar;
        e eVar2;
        com.baidu.tieba.enterForum.c.f fVar2;
        e eVar3;
        BdListView bdListView;
        eVar = this.bIk.bIi;
        fVar = eVar.bHZ;
        if (fVar.Yl() != null) {
            eVar2 = this.bIk.bIi;
            fVar2 = eVar2.bHZ;
            fVar2.Yl().setVisibility(0);
            eVar3 = this.bIk.bIi;
            bdListView = eVar3.bHV;
            bdListView.setVisibility(8);
        }
    }
}
