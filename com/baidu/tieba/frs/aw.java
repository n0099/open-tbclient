package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class aw implements SlidingMenu.OnClosedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1085a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(FrsImageActivity frsImageActivity) {
        this.f1085a = frsImageActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        boolean z;
        z = this.f1085a.r;
        if (z) {
            this.f1085a.r = false;
            this.f1085a.t = null;
            this.f1085a.f(1);
        }
    }
}
