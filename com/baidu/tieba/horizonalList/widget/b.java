package com.baidu.tieba.horizonalList.widget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ AbsHListView bQR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbsHListView absHListView) {
        this.bQR = absHListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bQR.bPS) {
            AbsHListView absHListView = this.bQR;
            this.bQR.bPT = false;
            absHListView.bPS = false;
            this.bQR.setChildrenDrawnWithCacheEnabled(false);
            if ((this.bQR.getPersistentDrawingCache() & 2) == 0) {
                this.bQR.setChildrenDrawingCacheEnabled(false);
            }
            if (!this.bQR.isAlwaysDrawnWithCacheEnabled()) {
                this.bQR.invalidate();
            }
        }
    }
}
