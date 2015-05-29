package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.g;
/* loaded from: classes.dex */
class e implements b {
    final /* synthetic */ d aeR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aeR = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.b
    public void onSuccess() {
        a aVar;
        g gVar;
        int i;
        aVar = this.aeR.aeQ;
        gVar = this.aeR.aeO;
        i = this.aeR.aeP;
        aVar.a(gVar, i, false);
    }
}
