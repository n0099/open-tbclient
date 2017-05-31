package com.baidu.tieba.horizonalList.widget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ AbsHListView cEr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbsHListView absHListView) {
        this.cEr = absHListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cEr.mCachingStarted) {
            AbsHListView absHListView = this.cEr;
            this.cEr.cDJ = false;
            absHListView.mCachingStarted = false;
            this.cEr.setChildrenDrawnWithCacheEnabled(false);
            if ((this.cEr.getPersistentDrawingCache() & 2) == 0) {
                this.cEr.setChildrenDrawingCacheEnabled(false);
            }
            if (!this.cEr.isAlwaysDrawnWithCacheEnabled()) {
                this.cEr.invalidate();
            }
        }
    }
}
