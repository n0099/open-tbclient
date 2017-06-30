package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends Handler {
    final /* synthetic */ GifView aDD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(GifView gifView, Looper looper) {
        super(looper);
        this.aDD = gifView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        int i2;
        boolean z;
        int i3;
        Bitmap bitmap;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        com.baidu.adp.gif.b gif = this.aDD.getGif();
        if (gif != null && message.what == 1) {
            GifView gifView = this.aDD;
            i = gifView.aDh;
            gifView.aDh = i + 1;
            i2 = this.aDD.aDh;
            if (i2 >= gif.dE()) {
                z2 = this.aDD.aDA;
                if (z2) {
                    z4 = this.aDD.aDx;
                    if (!z4) {
                        this.aDD.setVisibility(4);
                    }
                    this.aDD.aDA = false;
                    z = true;
                } else {
                    z = false;
                }
                z3 = this.aDD.aDx;
                if (!z3) {
                    this.aDD.aDh = 0;
                } else {
                    this.aDD.aDh = gif.dE() - 1;
                }
            } else {
                z = false;
            }
            i3 = this.aDD.aDh;
            gif.T(i3);
            bitmap = this.aDD.mBitmap;
            gif.a(bitmap, null);
            this.aDD.invalidate();
            removeMessages(1);
            if (!z) {
                i4 = this.aDD.aDh;
                sendEmptyMessageDelayed(1, gif.U(i4));
                return;
            }
            this.aDD.onStop();
        }
    }
}
