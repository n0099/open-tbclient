package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.coreExtra.share.implementation.a;
/* loaded from: classes.dex */
class b implements a.InterfaceC0043a {
    final /* synthetic */ a.c aji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a.c cVar) {
        this.aji = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.a.InterfaceC0043a
    public void onSuccess() {
        a aVar;
        f fVar;
        int i;
        aVar = a.this;
        fVar = this.aji.ajf;
        i = this.aji.ajg;
        aVar.a(fVar, i, false);
    }
}
