package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView TN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.TN = gifView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        WeakReference weakReference;
        WeakReference weakReference2;
        int i;
        int i2;
        boolean z;
        int i3;
        Bitmap bitmap;
        d dVar;
        d dVar2;
        int i4;
        boolean z2;
        weakReference = this.TN.Tr;
        if (weakReference != null) {
            weakReference2 = this.TN.Tr;
            com.baidu.adp.gif.c cVar = (com.baidu.adp.gif.c) weakReference2.get();
            if (cVar != null && message.what == 1) {
                GifView gifView = this.TN;
                i = gifView.Ts;
                gifView.Ts = i + 1;
                i2 = this.TN.Ts;
                if (i2 >= cVar.bj()) {
                    z2 = this.TN.TI;
                    if (z2) {
                        this.TN.setVisibility(4);
                        this.TN.TI = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    this.TN.Ts = 0;
                } else {
                    z = false;
                }
                i3 = this.TN.Ts;
                cVar.k(i3);
                bitmap = this.TN.mBitmap;
                cVar.a(bitmap, null);
                this.TN.invalidate();
                removeMessages(1);
                if (!z) {
                    i4 = this.TN.Ts;
                    sendEmptyMessageDelayed(1, cVar.l(i4));
                    return;
                }
                dVar = this.TN.Tt;
                if (dVar != null) {
                    dVar2 = this.TN.Tt;
                    dVar2.onStop();
                }
            }
        }
    }
}
