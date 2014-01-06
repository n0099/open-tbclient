package com.baidu.tieba.frs;

import com.baidu.tieba.model.cj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements cj {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.model.cj
    public void a(String str, long j) {
        com.baidu.tieba.model.ar arVar;
        arVar = this.a.q;
        arVar.a().setLike(0);
    }

    @Override // com.baidu.tieba.model.cj
    public void b(String str, long j) {
    }
}
