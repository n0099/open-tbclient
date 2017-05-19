package com.baidu.tieba.frs.tab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ HorizontalTabView bZt;
    private final /* synthetic */ int bZv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalTabView horizontalTabView, int i) {
        this.bZt = horizontalTabView;
        this.bZv = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bZt.scrollBy(0 - this.bZv, 0);
    }
}
