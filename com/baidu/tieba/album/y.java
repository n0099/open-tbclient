package com.baidu.tieba.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ v aiw;
    private final /* synthetic */ HorizontalScrollView aiy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(v vVar, HorizontalScrollView horizontalScrollView) {
        this.aiw = vVar;
        this.aiy = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aiy.fullScroll(66);
    }
}
