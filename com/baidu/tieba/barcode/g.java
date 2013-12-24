package com.baidu.tieba.barcode;

import android.view.SurfaceHolder;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ SurfaceHolder a;
    final /* synthetic */ CaptureActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(CaptureActivity captureActivity, SurfaceHolder surfaceHolder) {
        this.b = captureActivity;
        this.a = surfaceHolder;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.a);
    }
}
