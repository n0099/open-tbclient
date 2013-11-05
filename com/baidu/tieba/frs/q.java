package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class q implements SlidingMenu.OnClosedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1293a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.f1293a = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        ba baVar;
        ba baVar2;
        baVar = this.f1293a.o;
        if (baVar.a().h()) {
            baVar2 = this.f1293a.o;
            baVar2.a().b(false);
            this.f1293a.C();
        }
    }
}
