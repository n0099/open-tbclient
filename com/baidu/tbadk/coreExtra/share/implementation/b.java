package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.coreExtra.share.implementation.a;
/* loaded from: classes.dex */
class b implements a.InterfaceC0038a {
    final /* synthetic */ a.c anF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a.c cVar) {
        this.anF = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.a.InterfaceC0038a
    public void onSuccess() {
        a aVar;
        f fVar;
        int i;
        aVar = a.this;
        fVar = this.anF.anC;
        i = this.anF.anD;
        aVar.a(fVar, i, false);
    }
}
