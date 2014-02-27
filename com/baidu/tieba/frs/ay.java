package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
final class ay implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public final void onOpened() {
        com.baidu.tieba.util.cb.a(this.a, "frs_total_more", "frsclick", 1, new Object[0]);
    }
}
