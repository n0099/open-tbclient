package com.baidu.tieba.frs.tab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ HorizontalTabView cfF;
    private final /* synthetic */ int cfH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalTabView horizontalTabView, int i) {
        this.cfF = horizontalTabView;
        this.cfH = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cfF.scrollBy(0 - this.cfH, 0);
    }
}
