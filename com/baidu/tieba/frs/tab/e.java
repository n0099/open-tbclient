package com.baidu.tieba.frs.tab;

import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ HorizontalTabView bmg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalTabView horizontalTabView) {
        this.bmg = horizontalTabView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bmg.scrollBy(this.bmg.getContext().getResources().getDimensionPixelSize(n.e.ds160), 0);
    }
}
