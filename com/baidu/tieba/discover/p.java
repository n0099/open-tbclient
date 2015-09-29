package com.baidu.tieba.discover;

import com.baidu.tbadk.core.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements p.a {
    final /* synthetic */ a aKv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(a aVar) {
        this.aKv = aVar;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        boolean z2;
        u uVar;
        u uVar2;
        z2 = this.aKv.aKl;
        if (z2) {
            uVar2 = this.aKv.aKd;
            uVar2.Gx();
            return;
        }
        uVar = this.aKv.aKd;
        uVar.HF();
    }
}
