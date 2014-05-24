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
        ctVar = this.a.w;
        if (ctVar.n().d()) {
            ctVar2 = this.a.w;
            ctVar2.n().b(false);
            this.a.E();
        }
    }
}
