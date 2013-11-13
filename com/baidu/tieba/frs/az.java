package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class az implements SlidingMenu.OnClosedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1325a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(FrsImageActivity frsImageActivity) {
        this.f1325a = frsImageActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        boolean z;
        z = this.f1325a.p;
        if (z) {
            this.f1325a.p = false;
            this.f1325a.r = null;
            this.f1325a.c(1);
        }
    }
}
