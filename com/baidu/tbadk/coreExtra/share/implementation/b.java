package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.coreExtra.share.implementation.a;
/* loaded from: classes.dex */
class b implements a.InterfaceC0038a {
    final /* synthetic */ a.c amP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a.c cVar) {
        this.amP = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.a.InterfaceC0038a
    public void onSuccess() {
        a aVar;
        f fVar;
        int i;
        aVar = a.this;
        fVar = this.amP.amM;
        i = this.amP.amN;
        aVar.a(fVar, i, false);
    }
}
