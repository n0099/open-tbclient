package com.baidu.tieba.frs.tab;

import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ HorizontalTabView caK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalTabView horizontalTabView) {
        this.caK = horizontalTabView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.caK.scrollBy(this.caK.getContext().getResources().getDimensionPixelSize(w.f.ds160), 0);
    }
}
