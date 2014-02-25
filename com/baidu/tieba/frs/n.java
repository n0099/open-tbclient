package com.baidu.tieba.frs;

import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class n implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        cb.a(this.a, "frs_total_more", "frsclick", 1, new Object[0]);
    }
}
