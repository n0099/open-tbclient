package com.baidu.tieba.enterForum.c;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ h bFR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bFR = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        com.baidu.tieba.enterForum.model.e eVar2;
        e eVar3;
        com.baidu.tieba.enterForum.model.e eVar4;
        e eVar5;
        BdListView bdListView;
        eVar = this.bFR.bFP;
        eVar2 = eVar.bFI;
        if (eVar2.Wp() != null) {
            eVar3 = this.bFR.bFP;
            eVar4 = eVar3.bFI;
            eVar4.Wp().setVisibility(0);
            eVar5 = this.bFR.bFP;
            bdListView = eVar5.bii;
            bdListView.setVisibility(8);
        }
    }
}
