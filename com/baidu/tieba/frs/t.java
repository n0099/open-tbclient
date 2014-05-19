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
        cs csVar;
        cs csVar2;
        csVar = this.a.w;
        if (csVar.n().d()) {
            csVar2 = this.a.w;
            csVar2.n().b(false);
            this.a.D();
        }
    }
}
