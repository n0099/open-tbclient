package com.baidu.tieba.horizonalList.widget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ AbsHListView bDi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbsHListView absHListView) {
        this.bDi = absHListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bDi.bCj) {
            AbsHListView absHListView = this.bDi;
            this.bDi.bCk = false;
            absHListView.bCj = false;
            this.bDi.setChildrenDrawnWithCacheEnabled(false);
            if ((this.bDi.getPersistentDrawingCache() & 2) == 0) {
                this.bDi.setChildrenDrawingCacheEnabled(false);
            }
            if (!this.bDi.isAlwaysDrawnWithCacheEnabled()) {
                this.bDi.invalidate();
            }
        }
    }
}
