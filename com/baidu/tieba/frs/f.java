package com.baidu.tieba.frs;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class f implements SlidingMenu.OnOpenedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1099a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsActivity frsActivity) {
        this.f1099a = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        if (TiebaApplication.g().u()) {
            StatService.onEvent(this.f1099a, "frs_total_more", "frsclick", 1);
        }
    }
}
