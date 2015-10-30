package com.baidu.tieba.discover;

import com.baidu.tbadk.core.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements p.a {
    final /* synthetic */ a aKG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(a aVar) {
        this.aKG = aVar;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        boolean z2;
        u uVar;
        u uVar2;
        z2 = this.aKG.aKw;
        if (z2) {
            uVar2 = this.aKG.aKo;
            uVar2.Gt();
            return;
        }
        uVar = this.aKG.aKo;
        uVar.HB();
    }
}
