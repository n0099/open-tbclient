package com.baidu.tieba.frs.tab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ HorizontalTabView cdC;
    private final /* synthetic */ int cdD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, int i) {
        this.cdC = horizontalTabView;
        this.cdD = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cdC.scrollBy(0 - this.cdD, 0);
    }
}
