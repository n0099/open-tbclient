package com.baidu.tieba.enterForum.d;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g bdh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bdh = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.c.g gVar;
        e eVar2;
        com.baidu.tieba.enterForum.c.g gVar2;
        e eVar3;
        BdListView bdListView;
        eVar = this.bdh.bdf;
        gVar = eVar.bcZ;
        if (gVar.Oj() != null) {
            eVar2 = this.bdh.bdf;
            gVar2 = eVar2.bcZ;
            gVar2.Oj().setVisibility(0);
            eVar3 = this.bdh.bdf;
            bdListView = eVar3.bcV;
            bdListView.setVisibility(8);
        }
    }
}
