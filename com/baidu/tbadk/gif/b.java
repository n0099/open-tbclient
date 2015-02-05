package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView aaq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.aaq = gifView;
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
        weakReference = this.aaq.ZU;
        if (weakReference != null) {
            weakReference2 = this.aaq.ZU;
            com.baidu.adp.gif.c cVar = (com.baidu.adp.gif.c) weakReference2.get();
            if (cVar != null && message.what == 1) {
                GifView gifView = this.aaq;
                i = gifView.ZV;
                gifView.ZV = i + 1;
                i2 = this.aaq.ZV;
                if (i2 >= cVar.bI()) {
                    z2 = this.aaq.aal;
                    if (z2) {
                        this.aaq.setVisibility(4);
                        this.aaq.aal = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    this.aaq.ZV = 0;
                } else {
                    z = false;
                }
                i3 = this.aaq.ZV;
                cVar.B(i3);
                bitmap = this.aaq.mBitmap;
                cVar.a(bitmap, null);
                this.aaq.invalidate();
                removeMessages(1);
                if (!z) {
                    i4 = this.aaq.ZV;
                    sendEmptyMessageDelayed(1, cVar.C(i4));
                    return;
                }
                eVar = this.aaq.ZW;
                if (eVar != null) {
                    eVar2 = this.aaq.ZW;
                    eVar2.onStop();
                }
            }
        }
    }
}
