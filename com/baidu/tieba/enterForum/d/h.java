package com.baidu.tieba.enterForum.d;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g aNc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aNc = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.c.g gVar;
        e eVar2;
        com.baidu.tieba.enterForum.c.g gVar2;
        e eVar3;
        BdListView bdListView;
        eVar = this.aNc.aNa;
        gVar = eVar.aMU;
        if (gVar.IT() != null) {
            eVar2 = this.aNc.aNa;
            gVar2 = eVar2.aMU;
            gVar2.IT().setVisibility(0);
            eVar3 = this.aNc.aNa;
            bdListView = eVar3.aJj;
            bdListView.setVisibility(8);
        }
    }
}
