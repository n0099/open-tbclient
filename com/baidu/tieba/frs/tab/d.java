package com.baidu.tieba.frs.tab;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ HorizontalTabView baR;
    private final /* synthetic */ int baS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, int i) {
        this.baR = horizontalTabView;
        this.baS = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.baR.scrollBy(0 - this.baS, 0);
    }
}
