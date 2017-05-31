package com.baidu.tieba.card;

import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements v.b {
    final /* synthetic */ y bBb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(y yVar) {
        this.bBb = yVar;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(com.baidu.tieba.play.v vVar, int i, int i2) {
        this.bBb.f(true, 4);
        return true;
    }
}
