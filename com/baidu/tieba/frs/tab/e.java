package com.baidu.tieba.frs.tab;

import com.baidu.tieba.i;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ HorizontalTabView baR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalTabView horizontalTabView) {
        this.baR = horizontalTabView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.baR.scrollBy(this.baR.getContext().getResources().getDimensionPixelSize(i.d.ds160), 0);
    }
}
