package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tbadk.coreExtra.share.implementation.a;
/* loaded from: classes.dex */
class b implements a.InterfaceC0042a {
    final /* synthetic */ a.c att;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a.c cVar) {
        this.att = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.a.InterfaceC0042a
    public void onSuccess() {
        a aVar;
        h hVar;
        int i;
        aVar = a.this;
        hVar = this.att.atq;
        i = this.att.atr;
        aVar.a(hVar, i, false);
    }
}
