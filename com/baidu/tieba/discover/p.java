package com.baidu.tieba.discover;

import com.baidu.tbadk.core.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements p.a {
    final /* synthetic */ a aJA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(a aVar) {
        this.aJA = aVar;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        boolean z2;
        u uVar;
        u uVar2;
        z2 = this.aJA.aJq;
        if (z2) {
            uVar2 = this.aJA.aJi;
            uVar2.Gq();
            return;
        }
        uVar = this.aJA.aJi;
        uVar.Hy();
    }
}
