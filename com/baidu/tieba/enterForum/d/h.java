package com.baidu.tieba.enterForum.d;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g aDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aDQ = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.c.i iVar;
        e eVar2;
        com.baidu.tieba.enterForum.c.i iVar2;
        e eVar3;
        BdListView bdListView;
        eVar = this.aDQ.aDP;
        iVar = eVar.aDK;
        if (iVar.Hd() != null) {
            eVar2 = this.aDQ.aDP;
            iVar2 = eVar2.aDK;
            iVar2.Hd().setVisibility(0);
            eVar3 = this.aDQ.aDP;
            bdListView = eVar3.aBx;
            bdListView.setVisibility(8);
        }
    }
}
