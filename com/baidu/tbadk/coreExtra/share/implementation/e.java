package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
/* loaded from: classes.dex */
class e implements b {
    final /* synthetic */ d TD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.TD = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.b
    public void onSuccess() {
        a aVar;
        f fVar;
        int i;
        aVar = this.TD.TC;
        fVar = this.TD.TA;
        i = this.TD.TB;
        aVar.a(fVar, i, false);
    }
}
