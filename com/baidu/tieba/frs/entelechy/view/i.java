package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tieba.play.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements e.b {
    final /* synthetic */ a bXh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.bXh = aVar;
    }

    @Override // com.baidu.tieba.play.e.b
    public boolean onError(com.baidu.tieba.play.e eVar, int i, int i2) {
        this.bXh.Oa();
        this.bXh.e(true, 4);
        return true;
    }
}
