package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView alX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.alX = gifView;
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
        weakReference = this.alX.alB;
        if (weakReference != null) {
            weakReference2 = this.alX.alB;
            com.baidu.adp.gif.c cVar = (com.baidu.adp.gif.c) weakReference2.get();
            if (cVar != null && message.what == 1) {
                GifView gifView = this.alX;
                i = gifView.alC;
                gifView.alC = i + 1;
                i2 = this.alX.alC;
                if (i2 >= cVar.fl()) {
                    z2 = this.alX.alS;
                    if (z2) {
                        this.alX.setVisibility(4);
                        this.alX.alS = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    this.alX.alC = 0;
                } else {
                    z = false;
                }
                i3 = this.alX.alC;
                cVar.D(i3);
                bitmap = this.alX.mBitmap;
                cVar.a(bitmap, null);
                this.alX.invalidate();
                removeMessages(1);
                if (!z) {
                    i4 = this.alX.alC;
                    sendEmptyMessageDelayed(1, cVar.E(i4));
                    return;
                }
                dVar = this.alX.alD;
                if (dVar != null) {
                    dVar2 = this.alX.alD;
                    dVar2.onStop();
                }
            }
        }
    }
}
