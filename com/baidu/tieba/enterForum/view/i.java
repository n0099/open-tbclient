package com.baidu.tieba.enterForum.view;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ h bwU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bwU = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.c.f fVar;
        e eVar2;
        com.baidu.tieba.enterForum.c.f fVar2;
        e eVar3;
        BdListView bdListView;
        eVar = this.bwU.bwS;
        fVar = eVar.bwJ;
        if (fVar.Th() != null) {
            eVar2 = this.bwU.bwS;
            fVar2 = eVar2.bwJ;
            fVar2.Th().setVisibility(0);
            eVar3 = this.bwU.bwS;
            bdListView = eVar3.bwF;
            bdListView.setVisibility(8);
        }
    }
}
