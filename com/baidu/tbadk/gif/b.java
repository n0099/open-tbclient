package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView ayn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.ayn = gifView;
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
        com.baidu.adp.gif.b gif = this.ayn.getGif();
        if (gif != null && message.what == 1) {
            GifView gifView = this.ayn;
            i = gifView.axR;
            gifView.axR = i + 1;
            i2 = this.ayn.axR;
            if (i2 >= gif.cx()) {
                z2 = this.ayn.ayj;
                if (z2) {
                    z4 = this.ayn.ayg;
                    if (!z4) {
                        this.ayn.setVisibility(4);
                    }
                    this.ayn.ayj = false;
                    z = true;
                } else {
                    z = false;
                }
                z3 = this.ayn.ayg;
                if (!z3) {
                    this.ayn.axR = 0;
                } else {
                    this.ayn.axR = gif.cx() - 1;
                }
            } else {
                z = false;
            }
            i3 = this.ayn.axR;
            gif.U(i3);
            bitmap = this.ayn.mBitmap;
            gif.a(bitmap, null);
            this.ayn.invalidate();
            removeMessages(1);
            if (!z) {
                i4 = this.ayn.axR;
                sendEmptyMessageDelayed(1, gif.V(i4));
                return;
            }
            this.ayn.onStop();
        }
    }
}
