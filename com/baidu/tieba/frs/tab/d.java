package com.baidu.tieba.frs.tab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ HorizontalTabView bbL;
    private final /* synthetic */ int bbM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, int i) {
        this.bbL = horizontalTabView;
        this.bbM = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bbL.scrollBy(0 - this.bbM, 0);
    }
}
