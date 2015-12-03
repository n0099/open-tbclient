package com.baidu.tieba.frs.tab;

import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ HorizontalTabView biq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalTabView horizontalTabView) {
        this.biq = horizontalTabView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.biq.scrollBy(this.biq.getContext().getResources().getDimensionPixelSize(n.d.ds160), 0);
    }
}
