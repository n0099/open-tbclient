package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
/* loaded from: classes.dex */
class e implements b {
    final /* synthetic */ d Tc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.Tc = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.b
    public void onSuccess() {
        a aVar;
        f fVar;
        int i;
        aVar = this.Tc.Tb;
        fVar = this.Tc.SZ;
        i = this.Tc.Ta;
        aVar.a(fVar, i, false);
    }
}
