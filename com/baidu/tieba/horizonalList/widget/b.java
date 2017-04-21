package com.baidu.tieba.horizonalList.widget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ AbsHListView cEq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbsHListView absHListView) {
        this.cEq = absHListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cEq.cDq) {
            AbsHListView absHListView = this.cEq;
            this.cEq.cDr = false;
            absHListView.cDq = false;
            this.cEq.setChildrenDrawnWithCacheEnabled(false);
            if ((this.cEq.getPersistentDrawingCache() & 2) == 0) {
                this.cEq.setChildrenDrawingCacheEnabled(false);
            }
            if (!this.cEq.isAlwaysDrawnWithCacheEnabled()) {
                this.cEq.invalidate();
            }
        }
    }
}
