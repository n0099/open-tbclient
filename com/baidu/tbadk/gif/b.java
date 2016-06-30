package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView aur;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.aur = gifView;
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
        com.baidu.adp.gif.b gif = this.aur.getGif();
        if (gif != null && message.what == 1) {
            GifView gifView = this.aur;
            i = gifView.atV;
            gifView.atV = i + 1;
            i2 = this.aur.atV;
            if (i2 >= gif.bD()) {
                z2 = this.aur.aun;
                if (z2) {
                    z4 = this.aur.auk;
                    if (!z4) {
                        this.aur.setVisibility(4);
                    }
                    this.aur.aun = false;
                    z = true;
                } else {
                    z = false;
                }
                z3 = this.aur.auk;
                if (!z3) {
                    this.aur.atV = 0;
                } else {
                    this.aur.atV = gif.bD() - 1;
                }
            } else {
                z = false;
            }
            i3 = this.aur.atV;
            gif.E(i3);
            bitmap = this.aur.mBitmap;
            gif.a(bitmap, null);
            this.aur.invalidate();
            removeMessages(1);
            if (!z) {
                i4 = this.aur.atV;
                sendEmptyMessageDelayed(1, gif.F(i4));
                return;
            }
            this.aur.onStop();
        }
    }
}
