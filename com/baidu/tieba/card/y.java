package com.baidu.tieba.card;

import com.baidu.tieba.play.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements e.b {
    final /* synthetic */ r aZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(r rVar) {
        this.aZW = rVar;
    }

    @Override // com.baidu.tieba.play.e.b
    public boolean onError(com.baidu.tieba.play.e eVar, int i, int i2) {
        this.aZW.e(true, 4);
        return true;
    }
}
