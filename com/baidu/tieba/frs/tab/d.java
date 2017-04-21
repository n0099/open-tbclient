package com.baidu.tieba.frs.tab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ HorizontalTabView cbC;
    private final /* synthetic */ int cbD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, int i) {
        this.cbC = horizontalTabView;
        this.cbD = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cbC.scrollBy(0 - this.cbD, 0);
    }
}
