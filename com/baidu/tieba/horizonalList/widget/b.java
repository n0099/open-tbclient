package com.baidu.tieba.horizonalList.widget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ AbsHListView cyA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbsHListView absHListView) {
        this.cyA = absHListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cyA.cxA) {
            AbsHListView absHListView = this.cyA;
            this.cyA.cxB = false;
            absHListView.cxA = false;
            this.cyA.setChildrenDrawnWithCacheEnabled(false);
            if ((this.cyA.getPersistentDrawingCache() & 2) == 0) {
                this.cyA.setChildrenDrawingCacheEnabled(false);
            }
            if (!this.cyA.isAlwaysDrawnWithCacheEnabled()) {
                this.cyA.invalidate();
            }
        }
    }
}
