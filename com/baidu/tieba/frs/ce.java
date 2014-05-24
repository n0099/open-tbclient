package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements com.baidu.tieba.model.be {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.model.be
    public void a(String str, long j) {
        di diVar;
        diVar = this.a.t;
        diVar.b().setLike(0);
    }

    @Override // com.baidu.tieba.model.be
    public void b(String str, long j) {
    }
}
