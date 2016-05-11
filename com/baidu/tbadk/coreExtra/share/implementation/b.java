package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.coreExtra.share.implementation.a;
/* loaded from: classes.dex */
class b implements a.InterfaceC0037a {
    final /* synthetic */ a.c ajf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a.c cVar) {
        this.ajf = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.a.InterfaceC0037a
    public void onSuccess() {
        a aVar;
        f fVar;
        int i;
        aVar = a.this;
        fVar = this.ajf.ajc;
        i = this.ajf.ajd;
        aVar.a(fVar, i, false);
    }
}
