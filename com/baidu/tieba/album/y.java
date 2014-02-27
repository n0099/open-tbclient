package com.baidu.tieba.album;

import android.widget.HorizontalScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y implements Runnable {
    final /* synthetic */ v a;
    private final /* synthetic */ HorizontalScrollView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(v vVar, HorizontalScrollView horizontalScrollView) {
        this.a = vVar;
        this.b = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.fullScroll(66);
    }
}
