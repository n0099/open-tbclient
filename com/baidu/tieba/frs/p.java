package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class p implements SlidingMenu.OnClosedListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        bk bkVar;
        bk bkVar2;
        bkVar = this.a.n;
        if (bkVar.f().g()) {
            bkVar2 = this.a.n;
            bkVar2.f().c(false);
            this.a.z();
        }
    }
}
