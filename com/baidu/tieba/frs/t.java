package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
final class t implements SlidingMenu.OnClosedListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public final void onClosed() {
        cm cmVar;
        cm cmVar2;
        cmVar = this.a.r;
        if (cmVar.m().f()) {
            cmVar2 = this.a.r;
            cmVar2.m().b(false);
            this.a.n();
        }
    }
}
