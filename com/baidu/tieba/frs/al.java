package com.baidu.tieba.frs;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class al implements SlidingMenu.OnOpenedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1074a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsImageActivity frsImageActivity) {
        this.f1074a = frsImageActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        if (TiebaApplication.g().u()) {
            StatService.onEvent(this.f1074a, "frs_total_more", "frsclick", 1);
        }
    }
}
