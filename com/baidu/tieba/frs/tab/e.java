package com.baidu.tieba.frs.tab;

import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ HorizontalTabView bSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalTabView horizontalTabView) {
        this.bSw = horizontalTabView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bSw.scrollBy(this.bSw.getContext().getResources().getDimensionPixelSize(u.e.ds160), 0);
    }
}
