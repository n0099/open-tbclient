package com.baidu.tieba.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t aqH;
    private final /* synthetic */ HorizontalScrollView aqJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, HorizontalScrollView horizontalScrollView) {
        this.aqH = tVar;
        this.aqJ = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aqJ.fullScroll(66);
    }
}
