package com.baidu.tieba.frs.tab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ HorizontalTabView chB;
    private final /* synthetic */ int chC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, int i) {
        this.chB = horizontalTabView;
        this.chC = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.chB.scrollBy(0 - this.chC, 0);
    }
}
