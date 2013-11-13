package com.baidu.tieba.frs;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class v implements SlidingMenu.OnOpenedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1366a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity) {
        this.f1366a = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f1366a, "frs_total_more", "frsclick", 1);
        }
    }
}
