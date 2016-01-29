package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView awU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.awU = gifView;
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
        com.baidu.adp.gif.b gif = this.awU.getGif();
        if (gif != null && message.what == 1) {
            GifView gifView = this.awU;
            i = gifView.awx;
            gifView.awx = i + 1;
            i2 = this.awU.awx;
            if (i2 >= gif.fn()) {
                z2 = this.awU.awP;
                if (z2) {
                    z4 = this.awU.awM;
                    if (!z4) {
                        this.awU.setVisibility(4);
                    }
                    this.awU.awP = false;
                    z = true;
                } else {
                    z = false;
                }
                z3 = this.awU.awM;
                if (!z3) {
                    this.awU.awx = 0;
                } else {
                    this.awU.awx = gif.fn() - 1;
                }
            } else {
                z = false;
            }
            i3 = this.awU.awx;
            gif.R(i3);
            bitmap = this.awU.mBitmap;
            gif.a(bitmap, null);
            this.awU.invalidate();
            removeMessages(1);
            if (!z) {
                i4 = this.awU.awx;
                sendEmptyMessageDelayed(1, gif.S(i4));
                return;
            }
            this.awU.onStop();
        }
    }
}
