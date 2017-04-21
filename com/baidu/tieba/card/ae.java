package com.baidu.tieba.card;

import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements v.b {
    final /* synthetic */ x bvq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(x xVar) {
        this.bvq = xVar;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(com.baidu.tieba.play.v vVar, int i, int i2) {
        this.bvq.f(true, 4);
        return true;
    }
}
