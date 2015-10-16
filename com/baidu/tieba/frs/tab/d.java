package com.baidu.tieba.frs.tab;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ HorizontalTabView bbp;
    private final /* synthetic */ int bbq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, int i) {
        this.bbp = horizontalTabView;
        this.bbq = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bbp.scrollBy(0 - this.bbq, 0);
    }
}
