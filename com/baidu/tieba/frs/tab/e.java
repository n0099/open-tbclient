package com.baidu.tieba.frs.tab;

import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ HorizontalTabView bZl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalTabView horizontalTabView) {
        this.bZl = horizontalTabView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bZl.scrollBy(this.bZl.getContext().getResources().getDimensionPixelSize(w.f.ds160), 0);
    }
}
