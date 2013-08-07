package com.baidu.tieba.frs;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class aj implements SlidingMenu.OnOpenedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1058a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsImageActivity frsImageActivity) {
        this.f1058a = frsImageActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        if (TiebaApplication.f().t()) {
            StatService.onEvent(this.f1058a, "frs_total_more", "frsclick", 1);
        }
    }
}
