package com.baidu.tieba.barcode.a;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
/* loaded from: classes.dex */
final class f implements Camera.PreviewCallback {
    private final c a;
    private Handler b;
    private int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Handler handler, int i) {
        this.b = handler;
        this.c = i;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        Point a = this.a.a();
        Handler handler = this.b;
        if (a != null && handler != null) {
            handler.obtainMessage(this.c, a.x, a.y, bArr).sendToTarget();
            this.b = null;
            return;
        }
        com.baidu.adp.lib.util.f.e(getClass().getName(), "onPreviewFrame", "Got preview callback, but no handler or resolution available");
    }
}
