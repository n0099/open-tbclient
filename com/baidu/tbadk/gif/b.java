package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView ayI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.ayI = gifView;
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
        com.baidu.adp.gif.b gif = this.ayI.getGif();
        if (gif != null && message.what == 1) {
            GifView gifView = this.ayI;
            i = gifView.ayl;
            gifView.ayl = i + 1;
            i2 = this.ayI.ayl;
            if (i2 >= gif.cx()) {
                z2 = this.ayI.ayD;
                if (z2) {
                    z4 = this.ayI.ayA;
                    if (!z4) {
                        this.ayI.setVisibility(4);
                    }
                    this.ayI.ayD = false;
                    z = true;
                } else {
                    z = false;
                }
                z3 = this.ayI.ayA;
                if (!z3) {
                    this.ayI.ayl = 0;
                } else {
                    this.ayI.ayl = gif.cx() - 1;
                }
            } else {
                z = false;
            }
            i3 = this.ayI.ayl;
            gif.U(i3);
            bitmap = this.ayI.mBitmap;
            gif.a(bitmap, null);
            this.ayI.invalidate();
            removeMessages(1);
            if (!z) {
                i4 = this.ayI.ayl;
                sendEmptyMessageDelayed(1, gif.V(i4));
                return;
            }
            this.ayI.onStop();
        }
    }
}
