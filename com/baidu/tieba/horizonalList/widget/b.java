package com.baidu.tieba.horizonalList.widget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ AbsHListView cva;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbsHListView absHListView) {
        this.cva = absHListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cva.cua) {
            AbsHListView absHListView = this.cva;
            this.cva.cub = false;
            absHListView.cua = false;
            this.cva.setChildrenDrawnWithCacheEnabled(false);
            if ((this.cva.getPersistentDrawingCache() & 2) == 0) {
                this.cva.setChildrenDrawingCacheEnabled(false);
            }
            if (!this.cva.isAlwaysDrawnWithCacheEnabled()) {
                this.cva.invalidate();
            }
        }
    }
}
