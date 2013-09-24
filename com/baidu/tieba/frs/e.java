package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class e implements SlidingMenu.OnClosedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1146a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FrsActivity frsActivity) {
        this.f1146a = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        ba baVar;
        ba baVar2;
        baVar = this.f1146a.o;
        if (baVar.a().f()) {
            baVar2 = this.f1146a.o;
            baVar2.a().b(false);
            this.f1146a.D();
        }
    }
}
