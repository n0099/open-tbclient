package com.baidu.tieba.horizonalList.widget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ AbsHListView cBZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbsHListView absHListView) {
        this.cBZ = absHListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cBZ.cAZ) {
            AbsHListView absHListView = this.cBZ;
            this.cBZ.cBa = false;
            absHListView.cAZ = false;
            this.cBZ.setChildrenDrawnWithCacheEnabled(false);
            if ((this.cBZ.getPersistentDrawingCache() & 2) == 0) {
                this.cBZ.setChildrenDrawingCacheEnabled(false);
            }
            if (!this.cBZ.isAlwaysDrawnWithCacheEnabled()) {
                this.cBZ.invalidate();
            }
        }
    }
}
