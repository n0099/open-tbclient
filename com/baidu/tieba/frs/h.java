package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class h implements SlidingMenu.OnClosedListener {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        bp bpVar;
        bp bpVar2;
        bpVar = this.aDT.aCV;
        if (bpVar.GF().Ho()) {
            bpVar2 = this.aDT.aCV;
            bpVar2.GF().bX(false);
            this.aDT.refresh();
        }
    }
}
