package com.baidu.tieba.frs.tab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ HorizontalTabView boV;
    private final /* synthetic */ int boW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, int i) {
        this.boV = horizontalTabView;
        this.boW = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.boV.scrollBy(0 - this.boW, 0);
    }
}
