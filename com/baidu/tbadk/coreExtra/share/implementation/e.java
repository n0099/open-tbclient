package com.baidu.tbadk.coreExtra.share.implementation;

import com.baidu.tbadk.coreExtra.share.f;
/* loaded from: classes.dex */
class e implements b {
    final /* synthetic */ d TG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.TG = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.implementation.b
    public void onSuccess() {
        a aVar;
        f fVar;
        int i;
        aVar = this.TG.TF;
        fVar = this.TG.TD;
        i = this.TG.TE;
        aVar.a(fVar, i, false);
    }
}
