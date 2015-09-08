package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.coreExtra.share.implementation.a;
/* loaded from: classes.dex */
class b implements a.InterfaceC0043a {
    final /* synthetic */ a.c akh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a.c cVar) {
        this.akh = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.a.InterfaceC0043a
    public void onSuccess() {
        a aVar;
        f fVar;
        int i;
        aVar = a.this;
        fVar = this.akh.ake;
        i = this.akh.akf;
        aVar.a(fVar, i, false);
    }
}
