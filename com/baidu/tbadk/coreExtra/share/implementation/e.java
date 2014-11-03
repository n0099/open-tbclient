package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.h;
/* loaded from: classes.dex */
class e implements b {
    final /* synthetic */ d Nq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.Nq = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.b
    public void onSuccess() {
        a aVar;
        h hVar;
        int i;
        aVar = this.Nq.Np;
        hVar = this.Nq.Nn;
        i = this.Nq.No;
        aVar.a(hVar, i, false);
    }
}
