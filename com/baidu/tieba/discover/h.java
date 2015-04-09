package com.baidu.tieba.discover;

import com.baidu.tbadk.core.view.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements ae {
    final /* synthetic */ a aBS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.aBS = aVar;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        boolean z2;
        p pVar;
        p pVar2;
        z2 = this.aBS.aBM;
        if (z2) {
            pVar2 = this.aBS.aBE;
            pVar2.Fj();
            return;
        }
        pVar = this.aBS.aBE;
        pVar.Ge();
    }
}
