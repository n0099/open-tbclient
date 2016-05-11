package com.baidu.tieba.frs.tab;

import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ HorizontalTabView bsU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalTabView horizontalTabView) {
        this.bsU = horizontalTabView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bsU.scrollBy(this.bsU.getContext().getResources().getDimensionPixelSize(t.e.ds160), 0);
    }
}
