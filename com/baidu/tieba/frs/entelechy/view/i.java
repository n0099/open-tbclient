package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements v.b {
    final /* synthetic */ a bVG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.bVG = aVar;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(com.baidu.tieba.play.v vVar, int i, int i2) {
        this.bVG.SF();
        this.bVG.f(true, 4);
        return true;
    }
}
