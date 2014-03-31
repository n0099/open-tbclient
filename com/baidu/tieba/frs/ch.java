package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
final class ch implements SlidingMenu.OnClosedListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public final void onClosed() {
        boolean z;
        z = this.a.o;
        if (z) {
            this.a.o = false;
            this.a.q = null;
            this.a.b(1);
        }
    }
}
