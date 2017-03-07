package com.baidu.tieba.enterForum.c;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ h bFY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bFY = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.model.e eVar2;
        e eVar3;
        com.baidu.tieba.enterForum.model.e eVar4;
        e eVar5;
        BdListView bdListView;
        eVar = this.bFY.bFW;
        eVar2 = eVar.bFP;
        if (eVar2.VR() != null) {
            eVar3 = this.bFY.bFW;
            eVar4 = eVar3.bFP;
            eVar4.VR().setVisibility(0);
            eVar5 = this.bFY.bFW;
            bdListView = eVar5.bip;
            bdListView.setVisibility(8);
        }
    }
}
