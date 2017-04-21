package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends Handler {
    final /* synthetic */ GifView aCN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(GifView gifView, Looper looper) {
        super(looper);
        this.aCN = gifView;
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
        com.baidu.adp.gif.b gif = this.aCN.getGif();
        if (gif != null && message.what == 1) {
            GifView gifView = this.aCN;
            i = gifView.aCs;
            gifView.aCs = i + 1;
            i2 = this.aCN.aCs;
            if (i2 >= gif.dE()) {
                z2 = this.aCN.aCK;
                if (z2) {
                    z4 = this.aCN.aCH;
                    if (!z4) {
                        this.aCN.setVisibility(4);
                    }
                    this.aCN.aCK = false;
                    z = true;
                } else {
                    z = false;
                }
                z3 = this.aCN.aCH;
                if (!z3) {
                    this.aCN.aCs = 0;
                } else {
                    this.aCN.aCs = gif.dE() - 1;
                }
            } else {
                z = false;
            }
            i3 = this.aCN.aCs;
            gif.T(i3);
            bitmap = this.aCN.mBitmap;
            gif.a(bitmap, null);
            this.aCN.invalidate();
            removeMessages(1);
            if (!z) {
                i4 = this.aCN.aCs;
                sendEmptyMessageDelayed(1, gif.U(i4));
                return;
            }
            this.aCN.onStop();
        }
    }
}
