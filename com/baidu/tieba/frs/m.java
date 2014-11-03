package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class m implements SlidingMenu.OnClosedListener {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.aBu = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        bu buVar;
        bu buVar2;
        buVar = this.aBu.aAF;
        if (buVar.Gk().GQ()) {
            buVar2 = this.aBu.aAF;
            buVar2.Gk().ch(false);
            this.aBu.refresh();
        }
    }
}
