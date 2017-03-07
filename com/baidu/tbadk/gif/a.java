package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends Handler {
    final /* synthetic */ GifView aCv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(GifView gifView, Looper looper) {
        super(looper);
        this.aCv = gifView;
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
        com.baidu.adp.gif.b gif = this.aCv.getGif();
        if (gif != null && message.what == 1) {
            GifView gifView = this.aCv;
            i = gifView.aCa;
            gifView.aCa = i + 1;
            i2 = this.aCv.aCa;
            if (i2 >= gif.dE()) {
                z2 = this.aCv.aCs;
                if (z2) {
                    z4 = this.aCv.aCp;
                    if (!z4) {
                        this.aCv.setVisibility(4);
                    }
                    this.aCv.aCs = false;
                    z = true;
                } else {
                    z = false;
                }
                z3 = this.aCv.aCp;
                if (!z3) {
                    this.aCv.aCa = 0;
                } else {
                    this.aCv.aCa = gif.dE() - 1;
                }
            } else {
                z = false;
            }
            i3 = this.aCv.aCa;
            gif.V(i3);
            bitmap = this.aCv.mBitmap;
            gif.a(bitmap, null);
            this.aCv.invalidate();
            removeMessages(1);
            if (!z) {
                i4 = this.aCv.aCa;
                sendEmptyMessageDelayed(1, gif.W(i4));
                return;
            }
            this.aCv.onStop();
        }
    }
}
