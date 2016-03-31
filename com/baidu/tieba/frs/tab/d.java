package com.baidu.tieba.frs.tab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ HorizontalTabView btX;
    private final /* synthetic */ int btY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, int i) {
        this.btX = horizontalTabView;
        this.btY = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.btX.scrollBy(0 - this.btY, 0);
    }
}
