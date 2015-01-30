package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView aat;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.aat = gifView;
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
        e eVar;
        e eVar2;
        int i4;
        boolean z2;
        weakReference = this.aat.ZX;
        if (weakReference != null) {
            weakReference2 = this.aat.ZX;
            com.baidu.adp.gif.c cVar = (com.baidu.adp.gif.c) weakReference2.get();
            if (cVar != null && message.what == 1) {
                GifView gifView = this.aat;
                i = gifView.ZY;
                gifView.ZY = i + 1;
                i2 = this.aat.ZY;
                if (i2 >= cVar.bI()) {
                    z2 = this.aat.aao;
                    if (z2) {
                        this.aat.setVisibility(4);
                        this.aat.aao = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    this.aat.ZY = 0;
                } else {
                    z = false;
                }
                i3 = this.aat.ZY;
                cVar.B(i3);
                bitmap = this.aat.mBitmap;
                cVar.a(bitmap, null);
                this.aat.invalidate();
                removeMessages(1);
                if (!z) {
                    i4 = this.aat.ZY;
                    sendEmptyMessageDelayed(1, cVar.C(i4));
                    return;
                }
                eVar = this.aat.ZZ;
                if (eVar != null) {
                    eVar2 = this.aat.ZZ;
                    eVar2.onStop();
                }
            }
        }
    }
}
