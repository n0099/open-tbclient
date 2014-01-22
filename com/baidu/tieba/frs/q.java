package com.baidu.tieba.frs;

import com.baidu.tieba.util.by;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class q implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        by.a(this.a, "frs_total_more", "frsclick", 1, new Object[0]);
    }
}
