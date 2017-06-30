package com.baidu.tieba.frs.tab;

import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ HorizontalTabView cnV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(HorizontalTabView horizontalTabView) {
        this.cnV = horizontalTabView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cnV.scrollBy(this.cnV.getContext().getResources().getDimensionPixelSize(w.f.ds160), 0);
    }
}
