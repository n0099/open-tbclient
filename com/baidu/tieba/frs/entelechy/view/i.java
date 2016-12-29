package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tieba.play.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements t.b {
    final /* synthetic */ a bGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.bGf = aVar;
    }

    @Override // com.baidu.tieba.play.t.b
    public boolean onError(com.baidu.tieba.play.t tVar, int i, int i2) {
        this.bGf.Oy();
        this.bGf.e(true, 4);
        return true;
    }
}
