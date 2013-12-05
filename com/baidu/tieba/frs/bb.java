package com.baidu.tieba.frs;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class bb implements SlidingMenu.OnOpenedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1384a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(FrsImageActivity frsImageActivity) {
        this.f1384a = frsImageActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        if (TiebaApplication.h().t()) {
            StatService.onEvent(this.f1384a, "frs_total_more", "frsclick", 1);
        }
    }
}
