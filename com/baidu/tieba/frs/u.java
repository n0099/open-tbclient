package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class u implements SlidingMenu.OnClosedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1370a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.f1370a = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        bn bnVar;
        bn bnVar2;
        bnVar = this.f1370a.n;
        if (bnVar.e().g()) {
            bnVar2 = this.f1370a.n;
            bnVar2.e().b(false);
            this.f1370a.A();
        }
    }
}
