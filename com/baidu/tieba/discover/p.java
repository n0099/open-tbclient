package com.baidu.tieba.discover;

import com.baidu.tbadk.core.view.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements x.a {
    final /* synthetic */ a aLq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(a aVar) {
        this.aLq = aVar;
    }

    @Override // com.baidu.tbadk.core.view.x.a
    public void onListPullRefresh(boolean z) {
        boolean z2;
        u uVar;
        u uVar2;
        z2 = this.aLq.aLg;
        if (z2) {
            uVar2 = this.aLq.aKY;
            uVar2.GP();
            return;
        }
        uVar = this.aLq.aKY;
        uVar.HX();
    }
}
