package com.baidu.tieba.barcode;

import android.view.SurfaceHolder;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ CaptureActivity a;
    private final /* synthetic */ SurfaceHolder b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(CaptureActivity captureActivity, SurfaceHolder surfaceHolder) {
        this.a = captureActivity;
        this.b = surfaceHolder;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a(this.b);
    }
}
