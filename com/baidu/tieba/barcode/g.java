package com.baidu.tieba.barcode;

import android.view.SurfaceHolder;
/* loaded from: classes.dex */
class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SurfaceHolder f1147a;
    final /* synthetic */ CaptureActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(CaptureActivity captureActivity, SurfaceHolder surfaceHolder) {
        this.b = captureActivity;
        this.f1147a = surfaceHolder;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.f1147a);
    }
}
