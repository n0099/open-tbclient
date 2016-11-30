package com.baidu.tieba.card;

import com.baidu.tieba.play.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements t.b {
    final /* synthetic */ r bde;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(r rVar) {
        this.bde = rVar;
    }

    @Override // com.baidu.tieba.play.t.b
    public boolean onError(com.baidu.tieba.play.t tVar, int i, int i2) {
        this.bde.e(true, 4);
        return true;
    }
}
