package com.baidu.tieba.frs.tab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ HorizontalTabView cdA;
    private final /* synthetic */ int cdB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, int i) {
        this.cdA = horizontalTabView;
        this.cdB = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cdA.scrollBy(0 - this.cdB, 0);
    }
}
