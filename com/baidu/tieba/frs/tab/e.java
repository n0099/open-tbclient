package com.baidu.tieba.frs.tab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ HorizontalTabView cnV;
    private final /* synthetic */ int cnX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalTabView horizontalTabView, int i) {
        this.cnV = horizontalTabView;
        this.cnX = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cnV.scrollBy(0 - this.cnX, 0);
    }
}
