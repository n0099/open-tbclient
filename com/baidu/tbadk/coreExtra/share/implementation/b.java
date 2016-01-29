package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.coreExtra.share.implementation.a;
/* loaded from: classes.dex */
class b implements a.InterfaceC0046a {
    final /* synthetic */ a.c ana;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a.c cVar) {
        this.ana = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.a.InterfaceC0046a
    public void onSuccess() {
        a aVar;
        f fVar;
        int i;
        aVar = a.this;
        fVar = this.ana.amX;
        i = this.ana.amY;
        aVar.a(fVar, i, false);
    }
}
