package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
/* loaded from: classes.dex */
class e implements b {
    final /* synthetic */ d adN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.adN = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.b
    public void onSuccess() {
        a aVar;
        f fVar;
        int i;
        aVar = this.adN.adM;
        fVar = this.adN.adK;
        i = this.adN.adL;
        aVar.a(fVar, i, false);
    }
}
