package com.baidu.tieba.frs;

import com.baidu.tieba.view.dc;
/* loaded from: classes.dex */
class aq implements dc {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.view.dc
    public void a() {
        int i;
        FrsImageActivity frsImageActivity = this.a;
        i = this.a.h;
        frsImageActivity.d(i);
    }

    @Override // com.baidu.tieba.view.dc
    public void b() {
        this.a.f();
    }

    @Override // com.baidu.tieba.view.dc
    public void c() {
    }

    @Override // com.baidu.tieba.view.dc
    public void d() {
        this.a.f();
    }
}
