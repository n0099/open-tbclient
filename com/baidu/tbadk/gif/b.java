package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView ayf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.ayf = gifView;
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
        com.baidu.adp.gif.b gif = this.ayf.getGif();
        if (gif != null && message.what == 1) {
            GifView gifView = this.ayf;
            i = gifView.axI;
            gifView.axI = i + 1;
            i2 = this.ayf.axI;
            if (i2 >= gif.cx()) {
                z2 = this.ayf.aya;
                if (z2) {
                    z4 = this.ayf.axX;
                    if (!z4) {
                        this.ayf.setVisibility(4);
                    }
                    this.ayf.aya = false;
                    z = true;
                } else {
                    z = false;
                }
                z3 = this.ayf.axX;
                if (!z3) {
                    this.ayf.axI = 0;
                } else {
                    this.ayf.axI = gif.cx() - 1;
                }
            } else {
                z = false;
            }
            i3 = this.ayf.axI;
            gif.V(i3);
            bitmap = this.ayf.mBitmap;
            gif.a(bitmap, null);
            this.ayf.invalidate();
            removeMessages(1);
            if (!z) {
                i4 = this.ayf.axI;
                sendEmptyMessageDelayed(1, gif.W(i4));
                return;
            }
            this.ayf.onStop();
        }
    }
}
