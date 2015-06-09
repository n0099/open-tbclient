package com.baidu.tieba.discover;

import com.baidu.tbadk.core.view.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements aj {
    final /* synthetic */ a aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(a aVar) {
        this.aDT = aVar;
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        boolean z2;
        u uVar;
        u uVar2;
        z2 = this.aDT.aDJ;
        if (z2) {
            uVar2 = this.aDT.aDB;
            uVar2.Gd();
            return;
        }
        uVar = this.aDT.aDB;
        uVar.Hi();
    }
}
