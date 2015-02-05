package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Handler {
    final /* synthetic */ GiftGifView aau;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.aau = giftGifView;
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
        weakReference = this.aau.ZU;
        if (weakReference != null) {
            weakReference2 = this.aau.ZU;
            com.baidu.adp.gif.c cVar = (com.baidu.adp.gif.c) weakReference2.get();
            if (cVar != null) {
                if (message.what == 2) {
                    this.aau.aat = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.aau;
                    i = giftGifView.ZV;
                    giftGifView.ZV = i + 1;
                    i2 = this.aau.ZV;
                    if (i2 >= cVar.bI()) {
                        z2 = this.aau.aal;
                        if (!z2) {
                            z3 = this.aau.aat;
                            if (!z3) {
                                z = false;
                                this.aau.ZV = 0;
                            }
                        }
                        this.aau.setVisibility(4);
                        this.aau.aal = false;
                        z = true;
                        this.aau.ZV = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.aau.ZV;
                    cVar.B(i3);
                    bitmap = this.aau.mBitmap;
                    cVar.a(bitmap, null);
                    this.aau.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.aau.ZV;
                        sendEmptyMessageDelayed(1, cVar.C(i4));
                        return;
                    }
                    hVar = this.aau.aar;
                    if (hVar != null) {
                        hVar2 = this.aau.aar;
                        hVar2.onStop();
                    }
                }
            }
        }
    }
}
