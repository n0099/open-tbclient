package com.baidu.tieba.frs;
/* loaded from: classes.dex */
final class bx implements com.baidu.tieba.model.bd {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.model.bd
    public final void a(String str, long j) {
        da daVar;
        daVar = this.a.q;
        daVar.b().setLike(0);
    }

    @Override // com.baidu.tieba.model.bd
    public final void a() {
    }
}
