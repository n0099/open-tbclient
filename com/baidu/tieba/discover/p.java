package com.baidu.tieba.discover;

import com.baidu.tbadk.core.view.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements aj {
    final /* synthetic */ a aDS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(a aVar) {
        this.aDS = aVar;
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        boolean z2;
        u uVar;
        u uVar2;
        z2 = this.aDS.aDI;
        if (z2) {
            uVar2 = this.aDS.aDA;
            uVar2.Gc();
            return;
        }
        uVar = this.aDS.aDA;
        uVar.Hh();
    }
}
