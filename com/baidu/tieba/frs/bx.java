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
        cy cyVar;
        cyVar = this.a.q;
        cyVar.b().setLike(0);
    }

    @Override // com.baidu.tieba.model.bd
    public final void a() {
    }
}
