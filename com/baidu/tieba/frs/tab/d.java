package com.baidu.tieba.frs.tab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ HorizontalTabView bmg;
    private final /* synthetic */ int bmh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, int i) {
        this.bmg = horizontalTabView;
        this.bmh = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bmg.scrollBy(0 - this.bmh, 0);
    }
}
