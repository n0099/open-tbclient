package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView axQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.axQ = gifView;
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
        com.baidu.adp.gif.b gif = this.axQ.getGif();
        if (gif != null && message.what == 1) {
            GifView gifView = this.axQ;
            i = gifView.axu;
            gifView.axu = i + 1;
            i2 = this.axQ.axu;
            if (i2 >= gif.cx()) {
                z2 = this.axQ.axM;
                if (z2) {
                    z4 = this.axQ.axJ;
                    if (!z4) {
                        this.axQ.setVisibility(4);
                    }
                    this.axQ.axM = false;
                    z = true;
                } else {
                    z = false;
                }
                z3 = this.axQ.axJ;
                if (!z3) {
                    this.axQ.axu = 0;
                } else {
                    this.axQ.axu = gif.cx() - 1;
                }
            } else {
                z = false;
            }
            i3 = this.axQ.axu;
            gif.U(i3);
            bitmap = this.axQ.mBitmap;
            gif.a(bitmap, null);
            this.axQ.invalidate();
            removeMessages(1);
            if (!z) {
                i4 = this.axQ.axu;
                sendEmptyMessageDelayed(1, gif.V(i4));
                return;
            }
            this.axQ.onStop();
        }
    }
}
