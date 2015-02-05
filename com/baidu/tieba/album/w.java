package com.baidu.tieba.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t aqE;
    private final /* synthetic */ HorizontalScrollView aqG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, HorizontalScrollView horizontalScrollView) {
        this.aqE = tVar;
        this.aqG = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aqG.fullScroll(66);
    }
}
