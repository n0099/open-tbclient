package com.baidu.tieba.frs.tab;

import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ HorizontalTabView bQy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalTabView horizontalTabView) {
        this.bQy = horizontalTabView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bQy.scrollBy(this.bQy.getContext().getResources().getDimensionPixelSize(u.e.ds160), 0);
    }
}
