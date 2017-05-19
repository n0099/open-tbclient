package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends Handler {
    final /* synthetic */ GifView aCM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(GifView gifView, Looper looper) {
        super(looper);
        this.aCM = gifView;
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
        com.baidu.adp.gif.b gif = this.aCM.getGif();
        if (gif != null && message.what == 1) {
            GifView gifView = this.aCM;
            i = gifView.aCr;
            gifView.aCr = i + 1;
            i2 = this.aCM.aCr;
            if (i2 >= gif.dE()) {
                z2 = this.aCM.aCJ;
                if (z2) {
                    z4 = this.aCM.aCG;
                    if (!z4) {
                        this.aCM.setVisibility(4);
                    }
                    this.aCM.aCJ = false;
                    z = true;
                } else {
                    z = false;
                }
                z3 = this.aCM.aCG;
                if (!z3) {
                    this.aCM.aCr = 0;
                } else {
                    this.aCM.aCr = gif.dE() - 1;
                }
            } else {
                z = false;
            }
            i3 = this.aCM.aCr;
            gif.T(i3);
            bitmap = this.aCM.mBitmap;
            gif.a(bitmap, null);
            this.aCM.invalidate();
            removeMessages(1);
            if (!z) {
                i4 = this.aCM.aCr;
                sendEmptyMessageDelayed(1, gif.U(i4));
                return;
            }
            this.aCM.onStop();
        }
    }
}
