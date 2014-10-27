package com.baidu.tieba.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ v ain;
    private final /* synthetic */ HorizontalScrollView aip;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(v vVar, HorizontalScrollView horizontalScrollView) {
        this.ain = vVar;
        this.aip = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aip.fullScroll(66);
    }
}
