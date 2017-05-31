package com.baidu.tieba.frs.tab;

import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ HorizontalTabView cfF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(HorizontalTabView horizontalTabView) {
        this.cfF = horizontalTabView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cfF.scrollBy(this.cfF.getContext().getResources().getDimensionPixelSize(w.f.ds160), 0);
    }
}
