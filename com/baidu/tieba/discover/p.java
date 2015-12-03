package com.baidu.tieba.discover;

import com.baidu.tbadk.core.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements q.a {
    final /* synthetic */ a aOb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(a aVar) {
        this.aOb = aVar;
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        boolean z2;
        t tVar;
        t tVar2;
        z2 = this.aOb.aNR;
        if (z2) {
            tVar2 = this.aOb.aNJ;
            tVar2.Hx();
            return;
        }
        tVar = this.aOb.aNJ;
        tVar.IR();
    }
}
