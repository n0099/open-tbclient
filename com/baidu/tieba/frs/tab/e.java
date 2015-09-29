package com.baidu.tieba.frs.tab;

import com.baidu.tieba.i;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ HorizontalTabView bbe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalTabView horizontalTabView) {
        this.bbe = horizontalTabView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bbe.scrollBy(this.bbe.getContext().getResources().getDimensionPixelSize(i.d.ds160), 0);
    }
}
