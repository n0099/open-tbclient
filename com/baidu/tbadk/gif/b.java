package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView auz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.auz = gifView;
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
        com.baidu.adp.gif.b gif = this.auz.getGif();
        if (gif != null && message.what == 1) {
            GifView gifView = this.auz;
            i = gifView.auc;
            gifView.auc = i + 1;
            i2 = this.auz.auc;
            if (i2 >= gif.ff()) {
                z2 = this.auz.auu;
                if (z2) {
                    z4 = this.auz.aur;
                    if (!z4) {
                        this.auz.setVisibility(4);
                    }
                    this.auz.auu = false;
                    z = true;
                } else {
                    z = false;
                }
                z3 = this.auz.aur;
                if (!z3) {
                    this.auz.auc = 0;
                } else {
                    this.auz.auc = gif.ff() - 1;
                }
            } else {
                z = false;
            }
            i3 = this.auz.auc;
            gif.G(i3);
            bitmap = this.auz.mBitmap;
            gif.a(bitmap, null);
            this.auz.invalidate();
            removeMessages(1);
            if (!z) {
                i4 = this.auz.auc;
                sendEmptyMessageDelayed(1, gif.H(i4));
                return;
            }
            this.auz.onStop();
        }
    }
}
