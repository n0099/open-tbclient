package com.baidu.tieba.frs;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class aj implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        if (TiebaApplication.d().n()) {
            StatService.onEvent(this.a, "frs_total_more", "frsclick", 1);
        }
    }
}
