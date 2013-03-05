package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements com.baidu.tieba.view.am {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.view.am
    public void a() {
        int i;
        FrsImageActivity frsImageActivity = this.a;
        i = this.a.u;
        frsImageActivity.f(i);
    }

    @Override // com.baidu.tieba.view.am
    public void b() {
        this.a.k();
    }

    @Override // com.baidu.tieba.view.am
    public void c() {
    }

    @Override // com.baidu.tieba.view.am
    public void d() {
        this.a.k();
    }
}
