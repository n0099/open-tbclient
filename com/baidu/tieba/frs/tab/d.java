package com.baidu.tieba.frs.tab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ HorizontalTabView bZl;
    private final /* synthetic */ int bZm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, int i) {
        this.bZl = horizontalTabView;
        this.bZm = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bZl.scrollBy(0 - this.bZm, 0);
    }
}
