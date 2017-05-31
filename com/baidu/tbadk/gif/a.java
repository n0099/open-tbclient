package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends Handler {
    final /* synthetic */ GifView aCz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(GifView gifView, Looper looper) {
        super(looper);
        this.aCz = gifView;
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
        com.baidu.adp.gif.b gif = this.aCz.getGif();
        if (gif != null && message.what == 1) {
            GifView gifView = this.aCz;
            i = gifView.aCe;
            gifView.aCe = i + 1;
            i2 = this.aCz.aCe;
            if (i2 >= gif.dE()) {
                z2 = this.aCz.aCw;
                if (z2) {
                    z4 = this.aCz.aCt;
                    if (!z4) {
                        this.aCz.setVisibility(4);
                    }
                    this.aCz.aCw = false;
                    z = true;
                } else {
                    z = false;
                }
                z3 = this.aCz.aCt;
                if (!z3) {
                    this.aCz.aCe = 0;
                } else {
                    this.aCz.aCe = gif.dE() - 1;
                }
            } else {
                z = false;
            }
            i3 = this.aCz.aCe;
            gif.T(i3);
            bitmap = this.aCz.mBitmap;
            gif.a(bitmap, null);
            this.aCz.invalidate();
            removeMessages(1);
            if (!z) {
                i4 = this.aCz.aCe;
                sendEmptyMessageDelayed(1, gif.U(i4));
                return;
            }
            this.aCz.onStop();
        }
    }
}
