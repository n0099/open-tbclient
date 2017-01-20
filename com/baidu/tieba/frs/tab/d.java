package com.baidu.tieba.frs.tab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ HorizontalTabView bTy;
    private final /* synthetic */ int bTz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, int i) {
        this.bTy = horizontalTabView;
        this.bTz = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bTy.scrollBy(0 - this.bTz, 0);
    }
}
