package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements com.baidu.tieba.model.bg {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.model.bg
    public void a(String str, long j) {
        Cdo cdo;
        cdo = this.a.t;
        cdo.b().setLike(0);
    }

    @Override // com.baidu.tieba.model.bg
    public void b(String str, long j) {
    }
}
