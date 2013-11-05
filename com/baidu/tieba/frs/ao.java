package com.baidu.tieba.frs;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class ao implements SlidingMenu.OnOpenedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1258a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(FrsImageActivity frsImageActivity) {
        this.f1258a = frsImageActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f1258a, "frs_total_more", "frsclick", 1);
        }
    }
}
