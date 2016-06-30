package com.baidu.tieba.horizonalList.widget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ AbsHListView cvt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbsHListView absHListView) {
        this.cvt = absHListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cvt.cuu) {
            AbsHListView absHListView = this.cvt;
            this.cvt.cuv = false;
            absHListView.cuu = false;
            this.cvt.setChildrenDrawnWithCacheEnabled(false);
            if ((this.cvt.getPersistentDrawingCache() & 2) == 0) {
                this.cvt.setChildrenDrawingCacheEnabled(false);
            }
            if (!this.cvt.isAlwaysDrawnWithCacheEnabled()) {
                this.cvt.invalidate();
            }
        }
    }
}
