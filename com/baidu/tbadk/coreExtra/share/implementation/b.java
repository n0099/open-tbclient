package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.coreExtra.share.implementation.a;
/* loaded from: classes.dex */
class b implements a.InterfaceC0037a {
    final /* synthetic */ a.c ask;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a.c cVar) {
        this.ask = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.a.InterfaceC0037a
    public void onSuccess() {
        a aVar;
        g gVar;
        int i;
        aVar = a.this;
        gVar = this.ask.ash;
        i = this.ask.asi;
        aVar.a(gVar, i, false);
    }
}
