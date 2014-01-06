package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class t implements SlidingMenu.OnClosedListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        bo boVar;
        bo boVar2;
        boVar = this.a.n;
        if (boVar.f().g()) {
            boVar2 = this.a.n;
            boVar2.f().b(false);
            this.a.B();
        }
    }
}
