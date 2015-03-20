package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
/* loaded from: classes.dex */
class e implements b {
    final /* synthetic */ d adF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.adF = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.b
    public void onSuccess() {
        a aVar;
        f fVar;
        int i;
        aVar = this.adF.adE;
        fVar = this.adF.adC;
        i = this.adF.adD;
        aVar.a(fVar, i, false);
    }
}
