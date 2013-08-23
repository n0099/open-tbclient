package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class e implements SlidingMenu.OnClosedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1098a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FrsActivity frsActivity) {
        this.f1098a = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        boolean z;
        z = this.f1098a.E;
        if (z) {
            this.f1098a.E = false;
            this.f1098a.A();
        }
    }
}
