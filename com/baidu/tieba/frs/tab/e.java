package com.baidu.tieba.frs.tab;

import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ HorizontalTabView bbL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalTabView horizontalTabView) {
        this.bbL = horizontalTabView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bbL.scrollBy(this.bbL.getContext().getResources().getDimensionPixelSize(i.d.ds160), 0);
    }
}
