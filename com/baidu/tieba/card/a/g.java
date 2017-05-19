package com.baidu.tieba.card.a;

import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class g implements v.b {
    final /* synthetic */ a bwW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.bwW = aVar;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(v vVar, int i, int i2) {
        Runnable runnable;
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.bwW.aTS;
        fS.post(runnable);
        return false;
    }
}
