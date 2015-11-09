package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.coreExtra.share.implementation.a;
/* loaded from: classes.dex */
class b implements a.InterfaceC0043a {
    final /* synthetic */ a.c ajn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a.c cVar) {
        this.ajn = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.a.InterfaceC0043a
    public void onSuccess() {
        a aVar;
        f fVar;
        int i;
        aVar = a.this;
        fVar = this.ajn.ajk;
        i = this.ajn.ajl;
        aVar.a(fVar, i, false);
    }
}
