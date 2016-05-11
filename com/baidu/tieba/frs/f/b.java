package com.baidu.tieba.frs.f;

import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ a bsF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bsF = aVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        if (this.bsF.bsC != null) {
            this.bsF.bsC.onOpened();
        }
    }
}
