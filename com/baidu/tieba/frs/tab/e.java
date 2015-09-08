package com.baidu.tieba.frs.tab;

import com.baidu.tieba.i;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ HorizontalTabView bbl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalTabView horizontalTabView) {
        this.bbl = horizontalTabView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bbl.scrollBy(this.bbl.getContext().getResources().getDimensionPixelSize(i.d.ds160), 0);
    }
}
