package com.baidu.tieba.card;

import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements v.b {
    final /* synthetic */ u bvn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar) {
        this.bvn = uVar;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(com.baidu.tieba.play.v vVar, int i, int i2) {
        this.bvn.f(true, 4);
        return true;
    }
}
