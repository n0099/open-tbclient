package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView axB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.axB = gifView;
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
        com.baidu.adp.gif.b gif = this.axB.getGif();
        if (gif != null && message.what == 1) {
            GifView gifView = this.axB;
            i = gifView.axe;
            gifView.axe = i + 1;
            i2 = this.axB.axe;
            if (i2 >= gif.fo()) {
                z2 = this.axB.axw;
                if (z2) {
                    z4 = this.axB.axt;
                    if (!z4) {
                        this.axB.setVisibility(4);
                    }
                    this.axB.axw = false;
                    z = true;
                } else {
                    z = false;
                }
                z3 = this.axB.axt;
                if (!z3) {
                    this.axB.axe = 0;
                } else {
                    this.axB.axe = gif.fo() - 1;
                }
            } else {
                z = false;
            }
            i3 = this.axB.axe;
            gif.Q(i3);
            bitmap = this.axB.mBitmap;
            gif.a(bitmap, null);
            this.axB.invalidate();
            removeMessages(1);
            if (!z) {
                i4 = this.axB.axe;
                sendEmptyMessageDelayed(1, gif.R(i4));
                return;
            }
            this.axB.onStop();
        }
    }
}
