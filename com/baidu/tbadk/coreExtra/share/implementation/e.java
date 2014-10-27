package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.h;
/* loaded from: classes.dex */
class e implements b {
    final /* synthetic */ d Nm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.Nm = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.b
    public void onSuccess() {
        a aVar;
        h hVar;
        int i;
        aVar = this.Nm.Nl;
        hVar = this.Nm.Nj;
        i = this.Nm.Nk;
        aVar.a(hVar, i, false);
    }
}
