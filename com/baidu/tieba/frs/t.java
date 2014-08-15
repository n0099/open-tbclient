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
        cu cuVar;
        cu cuVar2;
        cuVar = this.a.z;
        if (cuVar.n().d()) {
            cuVar2 = this.a.z;
            cuVar2.n().b(false);
            this.a.D();
        }
    }
}
