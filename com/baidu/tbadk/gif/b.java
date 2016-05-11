package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView atC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.atC = gifView;
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
        com.baidu.adp.gif.b gif = this.atC.getGif();
        if (gif != null && message.what == 1) {
            GifView gifView = this.atC;
            i = gifView.atf;
            gifView.atf = i + 1;
            i2 = this.atC.atf;
            if (i2 >= gif.bC()) {
                z2 = this.atC.atx;
                if (z2) {
                    z4 = this.atC.atu;
                    if (!z4) {
                        this.atC.setVisibility(4);
                    }
                    this.atC.atx = false;
                    z = true;
                } else {
                    z = false;
                }
                z3 = this.atC.atu;
                if (!z3) {
                    this.atC.atf = 0;
                } else {
                    this.atC.atf = gif.bC() - 1;
                }
            } else {
                z = false;
            }
            i3 = this.atC.atf;
            gif.E(i3);
            bitmap = this.atC.mBitmap;
            gif.a(bitmap, null);
            this.atC.invalidate();
            removeMessages(1);
            if (!z) {
                i4 = this.atC.atf;
                sendEmptyMessageDelayed(1, gif.F(i4));
                return;
            }
            this.atC.onStop();
        }
    }
}
