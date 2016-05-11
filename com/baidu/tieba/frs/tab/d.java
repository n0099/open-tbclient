package com.baidu.tieba.frs.tab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ HorizontalTabView bsU;
    private final /* synthetic */ int bsV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, int i) {
        this.bsU = horizontalTabView;
        this.bsV = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bsU.scrollBy(0 - this.bsV, 0);
    }
}
