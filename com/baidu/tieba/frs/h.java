package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class h implements SlidingMenu.OnClosedListener {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        bp bpVar;
        bp bpVar2;
        bpVar = this.aDW.aCY;
        if (bpVar.GL().Hu()) {
            bpVar2 = this.aDW.aCY;
            bpVar2.GL().bX(false);
            this.aDW.refresh();
        }
    }
}
