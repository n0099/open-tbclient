package com.baidu.tieba.frs.tab;

import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ HorizontalTabView bTy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalTabView horizontalTabView) {
        this.bTy = horizontalTabView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bTy.scrollBy(this.bTy.getContext().getResources().getDimensionPixelSize(r.f.ds160), 0);
    }
}
