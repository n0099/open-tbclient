package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class h implements SlidingMenu.OnClosedListener {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        bq bqVar;
        bq bqVar2;
        bqVar = this.aCV.aBX;
        if (bqVar.Go().GW()) {
            bqVar2 = this.aCV.aBX;
            bqVar2.Go().bU(false);
            this.aCV.refresh();
        }
    }
}
