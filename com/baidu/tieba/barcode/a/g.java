package com.baidu.tieba.barcode.a;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements Camera.PreviewCallback {
    private final d a;
    private Handler b;
    private int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.a = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Handler handler, int i) {
        this.b = handler;
        this.c = i;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point a = this.a.a();
        Handler handler = this.b;
        if (a != null && handler != null) {
            handler.obtainMessage(this.c, a.x, a.y, bArr).sendToTarget();
            this.b = null;
            return;
        }
        com.baidu.adp.lib.g.e.e(getClass().getName(), "onPreviewFrame", "Got preview callback, but no handler or resolution available");
    }
}
