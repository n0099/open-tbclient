package com.baidu.tieba.horizonalList.widget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ AbsHListView cyi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbsHListView absHListView) {
        this.cyi = absHListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cyi.cxj) {
            AbsHListView absHListView = this.cyi;
            this.cyi.cxk = false;
            absHListView.cxj = false;
            this.cyi.setChildrenDrawnWithCacheEnabled(false);
            if ((this.cyi.getPersistentDrawingCache() & 2) == 0) {
                this.cyi.setChildrenDrawingCacheEnabled(false);
            }
            if (!this.cyi.isAlwaysDrawnWithCacheEnabled()) {
                this.cyi.invalidate();
            }
        }
    }
}
