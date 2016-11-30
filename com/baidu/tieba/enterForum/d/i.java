package com.baidu.tieba.enterForum.d;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ h bLd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bLd = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.c.f fVar;
        e eVar2;
        com.baidu.tieba.enterForum.c.f fVar2;
        e eVar3;
        BdListView bdListView;
        eVar = this.bLd.bLb;
        fVar = eVar.bKT;
        if (fVar.Zn() != null) {
            eVar2 = this.bLd.bLb;
            fVar2 = eVar2.bKT;
            fVar2.Zn().setVisibility(0);
            eVar3 = this.bLd.bLb;
            bdListView = eVar3.bKP;
            bdListView.setVisibility(8);
        }
    }
}
