package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tbadk.coreExtra.share.implementation.a;
/* loaded from: classes.dex */
class b implements a.InterfaceC0040a {
    final /* synthetic */ a.c asq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a.c cVar) {
        this.asq = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.a.InterfaceC0040a
    public void onSuccess() {
        a aVar;
        h hVar;
        int i;
        aVar = a.this;
        hVar = this.asq.asn;
        i = this.asq.aso;
        aVar.a(hVar, i, false);
    }
}
