package com.baidu.tieba.horizonalList.widget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ AbsHListView cKE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbsHListView absHListView) {
        this.cKE = absHListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cKE.cJF) {
            AbsHListView absHListView = this.cKE;
            this.cKE.cJG = false;
            absHListView.cJF = false;
            this.cKE.setChildrenDrawnWithCacheEnabled(false);
            if ((this.cKE.getPersistentDrawingCache() & 2) == 0) {
                this.cKE.setChildrenDrawingCacheEnabled(false);
            }
            if (!this.cKE.isAlwaysDrawnWithCacheEnabled()) {
                this.cKE.invalidate();
            }
        }
    }
}
