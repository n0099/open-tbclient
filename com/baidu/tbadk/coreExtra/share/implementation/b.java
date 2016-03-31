package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.coreExtra.share.implementation.a;
/* loaded from: classes.dex */
class b implements a.InterfaceC0046a {
    final /* synthetic */ a.c anr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a.c cVar) {
        this.anr = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.a.InterfaceC0046a
    public void onSuccess() {
        a aVar;
        f fVar;
        int i;
        aVar = a.this;
        fVar = this.anr.ano;
        i = this.anr.anp;
        aVar.a(fVar, i, false);
    }
}
