package com.baidu.tieba.frs.tab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ HorizontalTabView bNk;
    private final /* synthetic */ int bNl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, int i) {
        this.bNk = horizontalTabView;
        this.bNl = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bNk.scrollBy(0 - this.bNl, 0);
    }
}
