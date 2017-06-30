package com.baidu.tieba.card.a;

import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class g implements v.b {
    final /* synthetic */ a bDM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.bDM = aVar;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(v vVar, int i, int i2) {
        Runnable runnable;
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable = this.bDM.bDL;
        fR.post(runnable);
        return false;
    }
}
