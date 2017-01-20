package com.baidu.tieba.horizonalList.widget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ AbsHListView cCe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbsHListView absHListView) {
        this.cCe = absHListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cCe.cBe) {
            AbsHListView absHListView = this.cCe;
            this.cCe.cBf = false;
            absHListView.cBe = false;
            this.cCe.setChildrenDrawnWithCacheEnabled(false);
            if ((this.cCe.getPersistentDrawingCache() & 2) == 0) {
                this.cCe.setChildrenDrawingCacheEnabled(false);
            }
            if (!this.cCe.isAlwaysDrawnWithCacheEnabled()) {
                this.cCe.invalidate();
            }
        }
    }
}
