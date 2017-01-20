package com.baidu.tieba.enterForum.c;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ h byS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.byS = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.model.e eVar2;
        e eVar3;
        com.baidu.tieba.enterForum.model.e eVar4;
        e eVar5;
        BdListView bdListView;
        eVar = this.byS.byQ;
        eVar2 = eVar.byJ;
        if (eVar2.UT() != null) {
            eVar3 = this.byS.byQ;
            eVar4 = eVar3.byJ;
            eVar4.UT().setVisibility(0);
            eVar5 = this.byS.byQ;
            bdListView = eVar5.bbC;
            bdListView.setVisibility(8);
        }
    }
}
