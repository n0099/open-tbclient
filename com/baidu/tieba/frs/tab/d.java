package com.baidu.tieba.frs.tab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ HorizontalTabView bSw;
    private final /* synthetic */ int bSx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, int i) {
        this.bSw = horizontalTabView;
        this.bSx = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bSw.scrollBy(0 - this.bSx, 0);
    }
}
