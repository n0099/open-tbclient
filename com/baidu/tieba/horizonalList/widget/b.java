package com.baidu.tieba.horizonalList.widget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ AbsHListView cPU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbsHListView absHListView) {
        this.cPU = absHListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cPU.cOU) {
            AbsHListView absHListView = this.cPU;
            this.cPU.cOV = false;
            absHListView.cOU = false;
            this.cPU.setChildrenDrawnWithCacheEnabled(false);
            if ((this.cPU.getPersistentDrawingCache() & 2) == 0) {
                this.cPU.setChildrenDrawingCacheEnabled(false);
            }
            if (!this.cPU.isAlwaysDrawnWithCacheEnabled()) {
                this.cPU.invalidate();
            }
        }
    }
}
