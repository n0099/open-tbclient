package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.coreExtra.share.implementation.a;
/* loaded from: classes.dex */
class b implements a.InterfaceC0036a {
    final /* synthetic */ a.c asA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a.c cVar) {
        this.asA = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.a.InterfaceC0036a
    public void onSuccess() {
        a aVar;
        g gVar;
        int i;
        aVar = a.this;
        gVar = this.asA.asx;
        i = this.asA.asy;
        aVar.a(gVar, i, false);
    }
}
