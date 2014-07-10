package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class s implements SlidingMenu.OnClosedListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        ct ctVar;
        ct ctVar2;
        ctVar = this.a.v;
        if (ctVar.m().d()) {
            ctVar2 = this.a.v;
            ctVar2.m().b(false);
            this.a.E();
        }
    }
}
