package com.baidu.tieba.frs.tab;

import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ HorizontalTabView chB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalTabView horizontalTabView) {
        this.chB = horizontalTabView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.chB.scrollBy(this.chB.getContext().getResources().getDimensionPixelSize(r.e.ds160), 0);
    }
}
