package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class am implements SlidingMenu.OnClosedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1256a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsImageActivity frsImageActivity) {
        this.f1256a = frsImageActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        boolean z;
        z = this.f1256a.q;
        if (z) {
            this.f1256a.q = false;
            this.f1256a.s = null;
            this.f1256a.f(1);
        }
    }
}
