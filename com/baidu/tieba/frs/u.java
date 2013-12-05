package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class u implements SlidingMenu.OnClosedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1421a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.f1421a = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        bn bnVar;
        bn bnVar2;
        bnVar = this.f1421a.n;
        if (bnVar.f().g()) {
            bnVar2 = this.f1421a.n;
            bnVar2.f().b(false);
            this.f1421a.A();
        }
    }
}
