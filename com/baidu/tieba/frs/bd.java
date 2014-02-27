package com.baidu.tieba.frs;
/* loaded from: classes.dex */
final class bd implements com.baidu.tieba.model.by {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.model.by
    public final void a(String str, long j) {
        com.baidu.tieba.model.al alVar;
        alVar = this.a.q;
        alVar.b().setLike(0);
    }

    @Override // com.baidu.tieba.model.by
    public final void a() {
    }
}
