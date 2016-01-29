package com.baidu.tieba.horizonalList.widget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ AbsHListView bGu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbsHListView absHListView) {
        this.bGu = absHListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bGu.bFv) {
            AbsHListView absHListView = this.bGu;
            this.bGu.bFw = false;
            absHListView.bFv = false;
            this.bGu.setChildrenDrawnWithCacheEnabled(false);
            if ((this.bGu.getPersistentDrawingCache() & 2) == 0) {
                this.bGu.setChildrenDrawingCacheEnabled(false);
            }
            if (!this.bGu.isAlwaysDrawnWithCacheEnabled()) {
                this.bGu.invalidate();
            }
        }
    }
}
