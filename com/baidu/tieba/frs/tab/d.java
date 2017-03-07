package com.baidu.tieba.frs.tab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ HorizontalTabView caK;
    private final /* synthetic */ int caL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, int i) {
        this.caK = horizontalTabView;
        this.caL = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.caK.scrollBy(0 - this.caL, 0);
    }
}
