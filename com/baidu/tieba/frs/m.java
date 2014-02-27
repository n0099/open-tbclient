package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
final class m implements SlidingMenu.OnClosedListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public final void onClosed() {
        bs bsVar;
        bs bsVar2;
        bsVar = this.a.p;
        if (bsVar.f().f()) {
            bsVar2 = this.a.p;
            bsVar2.f().c(false);
            this.a.n();
        }
    }
}
