package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView avg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.avg = gifView;
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
        com.baidu.adp.gif.b gif = this.avg.getGif();
        if (gif != null && message.what == 1) {
            GifView gifView = this.avg;
            i = gifView.auK;
            gifView.auK = i + 1;
            i2 = this.avg.auK;
            if (i2 >= gif.bC()) {
                z2 = this.avg.avc;
                if (z2) {
                    z4 = this.avg.auZ;
                    if (!z4) {
                        this.avg.setVisibility(4);
                    }
                    this.avg.avc = false;
                    z = true;
                } else {
                    z = false;
                }
                z3 = this.avg.auZ;
                if (!z3) {
                    this.avg.auK = 0;
                } else {
                    this.avg.auK = gif.bC() - 1;
                }
            } else {
                z = false;
            }
            i3 = this.avg.auK;
            gif.H(i3);
            bitmap = this.avg.mBitmap;
            gif.a(bitmap, null);
            this.avg.invalidate();
            removeMessages(1);
            if (!z) {
                i4 = this.avg.auK;
                sendEmptyMessageDelayed(1, gif.I(i4));
                return;
            }
            this.avg.onStop();
        }
    }
}
