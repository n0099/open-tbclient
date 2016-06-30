package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.coreExtra.share.implementation.a;
/* loaded from: classes.dex */
class b implements a.InterfaceC0037a {
    final /* synthetic */ a.c ajL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a.c cVar) {
        this.ajL = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.a.InterfaceC0037a
    public void onSuccess() {
        a aVar;
        f fVar;
        int i;
        aVar = a.this;
        fVar = this.ajL.ajI;
        i = this.ajL.ajJ;
        aVar.a(fVar, i, false);
    }
}
