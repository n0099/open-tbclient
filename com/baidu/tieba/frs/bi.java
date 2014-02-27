package com.baidu.tieba.frs;

import com.baidu.tieba.view.di;
/* loaded from: classes.dex */
final class bi implements di {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.view.di
    public final void a() {
        int i;
        FrsImageActivity frsImageActivity = this.a;
        i = this.a.h;
        FrsImageActivity.f(frsImageActivity, i);
    }

    @Override // com.baidu.tieba.view.di
    public final void b() {
        this.a.c();
    }

    @Override // com.baidu.tieba.view.di
    public final void c() {
        this.a.c();
    }
}
