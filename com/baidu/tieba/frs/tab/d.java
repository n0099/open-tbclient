package com.baidu.tieba.frs.tab;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ HorizontalTabView bbe;
    private final /* synthetic */ int bbf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, int i) {
        this.bbe = horizontalTabView;
        this.bbf = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bbe.scrollBy(0 - this.bbf, 0);
    }
}
