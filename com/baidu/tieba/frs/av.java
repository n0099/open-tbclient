package com.baidu.tieba.frs;

import com.baidu.tieba.view.bx;
/* loaded from: classes.dex */
class av implements bx {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1326a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(FrsImageActivity frsImageActivity) {
        this.f1326a = frsImageActivity;
    }

    @Override // com.baidu.tieba.view.bx
    public void a() {
        int i;
        FrsImageActivity frsImageActivity = this.f1326a;
        i = this.f1326a.h;
        frsImageActivity.d(i);
    }

    @Override // com.baidu.tieba.view.bx
    public void b() {
        this.f1326a.f();
    }

    @Override // com.baidu.tieba.view.bx
    public void c() {
    }

    @Override // com.baidu.tieba.view.bx
    public void d() {
        this.f1326a.f();
    }
}
