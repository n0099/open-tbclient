package com.baidu.tieba.frs;

import com.baidu.tieba.view.di;
/* loaded from: classes.dex */
class bh implements di {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.view.di
    public void a() {
        int i;
        FrsImageActivity frsImageActivity = this.a;
        i = this.a.h;
        frsImageActivity.d(i);
    }

    @Override // com.baidu.tieba.view.di
    public void b() {
        this.a.g();
    }

    @Override // com.baidu.tieba.view.di
    public void c() {
    }

    @Override // com.baidu.tieba.view.di
    public void d() {
        this.a.g();
    }
}
