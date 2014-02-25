package com.baidu.tieba.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ u a;
    private final /* synthetic */ HorizontalScrollView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar, HorizontalScrollView horizontalScrollView) {
        this.a = uVar;
        this.b = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.fullScroll(66);
    }
}
