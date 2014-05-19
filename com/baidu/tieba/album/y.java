package com.baidu.tieba.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ v a;
    private final /* synthetic */ HorizontalScrollView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(v vVar, HorizontalScrollView horizontalScrollView) {
        this.a = vVar;
        this.b = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.fullScroll(66);
    }
}
