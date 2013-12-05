package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class az implements SlidingMenu.OnClosedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1381a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(FrsImageActivity frsImageActivity) {
        this.f1381a = frsImageActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        boolean z;
        z = this.f1381a.p;
        if (z) {
            this.f1381a.p = false;
            this.f1381a.r = null;
            this.f1381a.c(1);
        }
    }
}
