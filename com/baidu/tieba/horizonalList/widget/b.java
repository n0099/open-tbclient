package com.baidu.tieba.horizonalList.widget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ AbsHListView cMo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbsHListView absHListView) {
        this.cMo = absHListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cMo.mCachingStarted) {
            AbsHListView absHListView = this.cMo;
            this.cMo.cLG = false;
            absHListView.mCachingStarted = false;
            this.cMo.setChildrenDrawnWithCacheEnabled(false);
            if ((this.cMo.getPersistentDrawingCache() & 2) == 0) {
                this.cMo.setChildrenDrawingCacheEnabled(false);
            }
            if (!this.cMo.isAlwaysDrawnWithCacheEnabled()) {
                this.cMo.invalidate();
            }
        }
    }
}
