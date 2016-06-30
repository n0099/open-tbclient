package com.baidu.tieba.frs.tab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ HorizontalTabView bQy;
    private final /* synthetic */ int bQz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, int i) {
        this.bQy = horizontalTabView;
        this.bQz = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bQy.scrollBy(0 - this.bQz, 0);
    }
}
