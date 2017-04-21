package com.baidu.tieba.frs.tab;

import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ HorizontalTabView cbC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalTabView horizontalTabView) {
        this.cbC = horizontalTabView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cbC.scrollBy(this.cbC.getContext().getResources().getDimensionPixelSize(w.f.ds160), 0);
    }
}
