package com.baidu.tieba.frs;

import com.baidu.tieba.util.by;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class ax implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        by.a(this.a, "frs_total_more", "frsclick", 1, new Object[0]);
    }
}
