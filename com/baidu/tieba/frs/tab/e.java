package com.baidu.tieba.frs.tab;

import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ HorizontalTabView boV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalTabView horizontalTabView) {
        this.boV = horizontalTabView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.boV.scrollBy(this.boV.getContext().getResources().getDimensionPixelSize(t.e.ds160), 0);
    }
}
