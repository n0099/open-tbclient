package com.baidu.tieba.card;

import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements v.b {
    final /* synthetic */ x btf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(x xVar) {
        this.btf = xVar;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(com.baidu.tieba.play.v vVar, int i, int i2) {
        this.btf.e(true, 4);
        return true;
    }
}
