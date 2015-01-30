package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Handler {
    final /* synthetic */ GiftGifView aax;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.aax = giftGifView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        WeakReference weakReference;
        WeakReference weakReference2;
        int i;
        int i2;
        boolean z;
        int i3;
        Bitmap bitmap;
        h hVar;
        h hVar2;
        int i4;
        boolean z2;
        boolean z3;
        weakReference = this.aax.ZX;
        if (weakReference != null) {
            weakReference2 = this.aax.ZX;
            com.baidu.adp.gif.c cVar = (com.baidu.adp.gif.c) weakReference2.get();
            if (cVar != null) {
                if (message.what == 2) {
                    this.aax.aaw = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.aax;
                    i = giftGifView.ZY;
                    giftGifView.ZY = i + 1;
                    i2 = this.aax.ZY;
                    if (i2 >= cVar.bI()) {
                        z2 = this.aax.aao;
                        if (!z2) {
                            z3 = this.aax.aaw;
                            if (!z3) {
                                z = false;
                                this.aax.ZY = 0;
                            }
                        }
                        this.aax.setVisibility(4);
                        this.aax.aao = false;
                        z = true;
                        this.aax.ZY = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.aax.ZY;
                    cVar.B(i3);
                    bitmap = this.aax.mBitmap;
                    cVar.a(bitmap, null);
                    this.aax.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.aax.ZY;
                        sendEmptyMessageDelayed(1, cVar.C(i4));
                        return;
                    }
                    hVar = this.aax.aau;
                    if (hVar != null) {
                        hVar2 = this.aax.aau;
                        hVar2.onStop();
                    }
                }
            }
        }
    }
}
