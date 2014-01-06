package com.baidu.tieba.frs;

import com.baidu.tieba.view.cm;
/* loaded from: classes.dex */
class au implements cm {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.view.cm
    public void a() {
        int i;
        FrsImageActivity frsImageActivity = this.a;
        i = this.a.h;
        frsImageActivity.d(i);
    }

    @Override // com.baidu.tieba.view.cm
    public void b() {
        this.a.f();
    }

    @Override // com.baidu.tieba.view.cm
    public void c() {
    }

    @Override // com.baidu.tieba.view.cm
    public void d() {
        this.a.f();
    }
}
