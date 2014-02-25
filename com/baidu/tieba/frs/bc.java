package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements com.baidu.tieba.model.by {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.model.by
    public void a(String str, long j) {
        com.baidu.tieba.model.al alVar;
        alVar = this.a.q;
        alVar.b().setLike(0);
    }

    @Override // com.baidu.tieba.model.by
    public void b(String str, long j) {
    }
}
