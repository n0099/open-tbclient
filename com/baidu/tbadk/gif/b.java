package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView akW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.akW = gifView;
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
        weakReference = this.akW.akA;
        if (weakReference != null) {
            weakReference2 = this.akW.akA;
            com.baidu.adp.gif.c cVar = (com.baidu.adp.gif.c) weakReference2.get();
            if (cVar != null && message.what == 1) {
                GifView gifView = this.akW;
                i = gifView.akB;
                gifView.akB = i + 1;
                i2 = this.akW.akB;
                if (i2 >= cVar.fg()) {
                    z2 = this.akW.akR;
                    if (z2) {
                        this.akW.setVisibility(4);
                        this.akW.akR = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    this.akW.akB = 0;
                } else {
                    z = false;
                }
                i3 = this.akW.akB;
                cVar.C(i3);
                bitmap = this.akW.mBitmap;
                cVar.a(bitmap, null);
                this.akW.invalidate();
                removeMessages(1);
                if (!z) {
                    i4 = this.akW.akB;
                    sendEmptyMessageDelayed(1, cVar.D(i4));
                    return;
                }
                eVar = this.akW.akC;
                if (eVar != null) {
                    eVar2 = this.akW.akC;
                    eVar2.onStop();
                }
            }
        }
    }
}
