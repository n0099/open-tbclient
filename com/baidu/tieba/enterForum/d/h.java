package com.baidu.tieba.enterForum.d;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g aMJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aMJ = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.c.g gVar;
        e eVar2;
        com.baidu.tieba.enterForum.c.g gVar2;
        e eVar3;
        BdListView bdListView;
        eVar = this.aMJ.aMH;
        gVar = eVar.aMB;
        if (gVar.IH() != null) {
            eVar2 = this.aMJ.aMH;
            gVar2 = eVar2.aMB;
            gVar2.IH().setVisibility(0);
            eVar3 = this.aMJ.aMH;
            bdListView = eVar3.aKe;
            bdListView.setVisibility(8);
        }
    }
}
