package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class m implements SlidingMenu.OnClosedListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        br brVar;
        br brVar2;
        brVar = this.a.p;
        if (brVar.f().g()) {
            brVar2 = this.a.p;
            brVar2.f().c(false);
            this.a.C();
        }
    }
}
