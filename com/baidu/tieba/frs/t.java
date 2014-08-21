package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class t implements SlidingMenu.OnClosedListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        cv cvVar;
        cv cvVar2;
        cvVar = this.a.B;
        if (cvVar.n().d()) {
            cvVar2 = this.a.B;
            cvVar2.n().b(false);
            this.a.E();
        }
    }
}
