package com.baidu.tieba.barcode.a;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import com.baidu.tieba.util.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements Camera.PreviewCallback {

    /* renamed from: a  reason: collision with root package name */
    private final d f1140a;
    private Handler b;
    private int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.f1140a = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Handler handler, int i) {
        this.b = handler;
        this.c = i;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point a2 = this.f1140a.a();
        Handler handler = this.b;
        if (a2 != null && handler != null) {
            handler.obtainMessage(this.c, a2.x, a2.y, bArr).sendToTarget();
            this.b = null;
            return;
        }
        bd.e(getClass().getName(), "onPreviewFrame", "Got preview callback, but no handler or resolution available");
    }
}
