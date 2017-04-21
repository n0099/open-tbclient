package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tbadk.coreExtra.share.implementation.a;
/* loaded from: classes.dex */
class b implements a.InterfaceC0036a {
    final /* synthetic */ a.c asC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a.c cVar) {
        this.asC = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.a.InterfaceC0036a
    public void onSuccess() {
        a aVar;
        h hVar;
        int i;
        aVar = a.this;
        hVar = this.asC.asz;
        i = this.asC.asA;
        aVar.a(hVar, i, false);
    }
}
