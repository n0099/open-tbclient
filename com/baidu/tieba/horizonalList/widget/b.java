package com.baidu.tieba.horizonalList.widget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ AbsHListView cJN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbsHListView absHListView) {
        this.cJN = absHListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cJN.cIO) {
            AbsHListView absHListView = this.cJN;
            this.cJN.cIP = false;
            absHListView.cIO = false;
            this.cJN.setChildrenDrawnWithCacheEnabled(false);
            if ((this.cJN.getPersistentDrawingCache() & 2) == 0) {
                this.cJN.setChildrenDrawingCacheEnabled(false);
            }
            if (!this.cJN.isAlwaysDrawnWithCacheEnabled()) {
                this.cJN.invalidate();
            }
        }
    }
}
