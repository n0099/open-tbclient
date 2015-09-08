package com.baidu.tieba.frs.tab;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ HorizontalTabView bbl;
    private final /* synthetic */ int bbm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, int i) {
        this.bbl = horizontalTabView;
        this.bbm = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bbl.scrollBy(0 - this.bbm, 0);
    }
}
