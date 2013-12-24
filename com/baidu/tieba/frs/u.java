package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class u implements SlidingMenu.OnClosedListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        bn bnVar;
        bn bnVar2;
        bnVar = this.a.n;
        if (bnVar.f().g()) {
            bnVar2 = this.a.n;
            bnVar2.f().b(false);
            this.a.A();
        }
    }
}
