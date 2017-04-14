package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends Handler {
    final /* synthetic */ GifView aCL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(GifView gifView, Looper looper) {
        super(looper);
        this.aCL = gifView;
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
        com.baidu.adp.gif.b gif = this.aCL.getGif();
        if (gif != null && message.what == 1) {
            GifView gifView = this.aCL;
            i = gifView.aCq;
            gifView.aCq = i + 1;
            i2 = this.aCL.aCq;
            if (i2 >= gif.dD()) {
                z2 = this.aCL.aCI;
                if (z2) {
                    z4 = this.aCL.aCF;
                    if (!z4) {
                        this.aCL.setVisibility(4);
                    }
                    this.aCL.aCI = false;
                    z = true;
                } else {
                    z = false;
                }
                z3 = this.aCL.aCF;
                if (!z3) {
                    this.aCL.aCq = 0;
                } else {
                    this.aCL.aCq = gif.dD() - 1;
                }
            } else {
                z = false;
            }
            i3 = this.aCL.aCq;
            gif.T(i3);
            bitmap = this.aCL.mBitmap;
            gif.a(bitmap, null);
            this.aCL.invalidate();
            removeMessages(1);
            if (!z) {
                i4 = this.aCL.aCq;
                sendEmptyMessageDelayed(1, gif.U(i4));
                return;
            }
            this.aCL.onStop();
        }
    }
}
