package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView awd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.awd = gifView;
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
        com.baidu.adp.gif.b gif = this.awd.getGif();
        if (gif != null && message.what == 1) {
            GifView gifView = this.awd;
            i = gifView.avG;
            gifView.avG = i + 1;
            i2 = this.awd.avG;
            if (i2 >= gif.ff()) {
                z2 = this.awd.avY;
                if (z2) {
                    z4 = this.awd.avV;
                    if (!z4) {
                        this.awd.setVisibility(4);
                    }
                    this.awd.avY = false;
                    z = true;
                } else {
                    z = false;
                }
                z3 = this.awd.avV;
                if (!z3) {
                    this.awd.avG = 0;
                } else {
                    this.awd.avG = gif.ff() - 1;
                }
            } else {
                z = false;
            }
            i3 = this.awd.avG;
            gif.G(i3);
            bitmap = this.awd.mBitmap;
            gif.a(bitmap, null);
            this.awd.invalidate();
            removeMessages(1);
            if (!z) {
                i4 = this.awd.avG;
                sendEmptyMessageDelayed(1, gif.H(i4));
                return;
            }
            this.awd.onStop();
        }
    }
}
