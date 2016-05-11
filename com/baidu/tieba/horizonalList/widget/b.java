package com.baidu.tieba.horizonalList.widget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ AbsHListView bRs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbsHListView absHListView) {
        this.bRs = absHListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bRs.bQt) {
            AbsHListView absHListView = this.bRs;
            this.bRs.bQu = false;
            absHListView.bQt = false;
            this.bRs.setChildrenDrawnWithCacheEnabled(false);
            if ((this.bRs.getPersistentDrawingCache() & 2) == 0) {
                this.bRs.setChildrenDrawingCacheEnabled(false);
            }
            if (!this.bRs.isAlwaysDrawnWithCacheEnabled()) {
                this.bRs.invalidate();
            }
        }
    }
}
