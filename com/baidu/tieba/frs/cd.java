package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements com.baidu.tieba.model.bd {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.model.bd
    public void a(String str, long j) {
        dh dhVar;
        dhVar = this.a.t;
        dhVar.b().setLike(0);
    }

    @Override // com.baidu.tieba.model.bd
    public void b(String str, long j) {
    }
}
