package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.coreExtra.share.implementation.a;
/* loaded from: classes.dex */
class b implements a.InterfaceC0045a {
    final /* synthetic */ a.c amh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a.c cVar) {
        this.amh = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.a.InterfaceC0045a
    public void onSuccess() {
        a aVar;
        f fVar;
        int i;
        aVar = a.this;
        fVar = this.amh.ame;
        i = this.amh.amf;
        aVar.a(fVar, i, false);
    }
}
