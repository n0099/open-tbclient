package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends Handler {
    final /* synthetic */ GifView axb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(GifView gifView, Looper looper) {
        super(looper);
        this.axb = gifView;
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
        com.baidu.adp.gif.b gif = this.axb.getGif();
        if (gif != null && message.what == 1) {
            GifView gifView = this.axb;
            i = gifView.awG;
            gifView.awG = i + 1;
            i2 = this.axb.awG;
            if (i2 >= gif.cv()) {
                z2 = this.axb.awY;
                if (z2) {
                    z4 = this.axb.awV;
                    if (!z4) {
                        this.axb.setVisibility(4);
                    }
                    this.axb.awY = false;
                    z = true;
                } else {
                    z = false;
                }
                z3 = this.axb.awV;
                if (!z3) {
                    this.axb.awG = 0;
                } else {
                    this.axb.awG = gif.cv() - 1;
                }
            } else {
                z = false;
            }
            i3 = this.axb.awG;
            gif.V(i3);
            bitmap = this.axb.mBitmap;
            gif.a(bitmap, null);
            this.axb.invalidate();
            removeMessages(1);
            if (!z) {
                i4 = this.axb.awG;
                sendEmptyMessageDelayed(1, gif.W(i4));
                return;
            }
            this.axb.onStop();
        }
    }
}
