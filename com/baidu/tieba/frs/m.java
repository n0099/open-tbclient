package com.baidu.tieba.frs;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class m implements SlidingMenu.OnClosedListener {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        bu buVar;
        bu buVar2;
        buVar = this.aBk.aAv;
        if (buVar.Gi().GO()) {
            buVar2 = this.aBk.aAv;
            buVar2.Gi().ch(false);
            this.aBk.refresh();
        }
    }
}
