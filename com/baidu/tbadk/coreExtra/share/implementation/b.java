package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.coreExtra.share.implementation.a;
/* loaded from: classes.dex */
class b implements a.InterfaceC0038a {
    final /* synthetic */ a.c akA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a.c cVar) {
        this.akA = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.a.InterfaceC0038a
    public void onSuccess() {
        a aVar;
        f fVar;
        int i;
        aVar = a.this;
        fVar = this.akA.akx;
        i = this.akA.aky;
        aVar.a(fVar, i, false);
    }
}
