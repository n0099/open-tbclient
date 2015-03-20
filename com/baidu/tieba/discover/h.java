package com.baidu.tieba.discover;

import com.baidu.tbadk.core.view.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements ae {
    final /* synthetic */ a aBK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.aBK = aVar;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        boolean z2;
        p pVar;
        p pVar2;
        z2 = this.aBK.aBE;
        if (z2) {
            pVar2 = this.aBK.aBw;
            pVar2.Fd();
            return;
        }
        pVar = this.aBK.aBw;
        pVar.FY();
    }
}
