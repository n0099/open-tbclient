package com.baidu.tbadk.motu_gallery;

import android.os.Handler;
/* loaded from: classes.dex */
final class f implements Runnable {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        d.e(this.a);
        handler = this.a.u;
        handler2 = this.a.u;
        handler.sendMessage(handler2.obtainMessage(2));
    }
}
