package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class az implements SlidingMenu.OnClosedListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        boolean z;
        z = this.a.p;
        if (z) {
            this.a.p = false;
            this.a.r = null;
            this.a.c(1);
        }
    }
}
