package com.baidu.tieba.frs.f;

import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements SlidingMenu.OnClosedListener {
    final /* synthetic */ a bsF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bsF = aVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        if (this.bsF.bsC != null) {
            this.bsF.bsC.onClosed();
        }
    }
}
