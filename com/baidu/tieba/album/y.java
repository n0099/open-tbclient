package com.baidu.tieba.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ v apJ;
    private final /* synthetic */ HorizontalScrollView apL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(v vVar, HorizontalScrollView horizontalScrollView) {
        this.apJ = vVar;
        this.apL = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.apL.fullScroll(66);
    }
}
