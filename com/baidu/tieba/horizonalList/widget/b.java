package com.baidu.tieba.horizonalList.widget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ AbsHListView cDA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbsHListView absHListView) {
        this.cDA = absHListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cDA.cCA) {
            AbsHListView absHListView = this.cDA;
            this.cDA.cCB = false;
            absHListView.cCA = false;
            this.cDA.setChildrenDrawnWithCacheEnabled(false);
            if ((this.cDA.getPersistentDrawingCache() & 2) == 0) {
                this.cDA.setChildrenDrawingCacheEnabled(false);
            }
            if (!this.cDA.isAlwaysDrawnWithCacheEnabled()) {
                this.cDA.invalidate();
            }
        }
    }
}
