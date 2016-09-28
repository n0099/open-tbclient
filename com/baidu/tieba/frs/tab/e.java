package com.baidu.tieba.frs.tab;

import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ HorizontalTabView cdA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalTabView horizontalTabView) {
        this.cdA = horizontalTabView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cdA.scrollBy(this.cdA.getContext().getResources().getDimensionPixelSize(r.e.ds160), 0);
    }
}
