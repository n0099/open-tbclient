package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Handler {
    final /* synthetic */ GiftGifView ala;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.ala = giftGifView;
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
        weakReference = this.ala.akA;
        if (weakReference != null) {
            weakReference2 = this.ala.akA;
            com.baidu.adp.gif.c cVar = (com.baidu.adp.gif.c) weakReference2.get();
            if (cVar != null) {
                if (message.what == 2) {
                    this.ala.akZ = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.ala;
                    i = giftGifView.akB;
                    giftGifView.akB = i + 1;
                    i2 = this.ala.akB;
                    if (i2 >= cVar.fg()) {
                        z2 = this.ala.akR;
                        if (!z2) {
                            z3 = this.ala.akZ;
                            if (!z3) {
                                z = false;
                                this.ala.akB = 0;
                            }
                        }
                        this.ala.setVisibility(4);
                        this.ala.akR = false;
                        z = true;
                        this.ala.akB = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.ala.akB;
                    cVar.C(i3);
                    bitmap = this.ala.mBitmap;
                    cVar.a(bitmap, null);
                    this.ala.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.ala.akB;
                        sendEmptyMessageDelayed(1, cVar.D(i4));
                        return;
                    }
                    hVar = this.ala.akX;
                    if (hVar != null) {
                        hVar2 = this.ala.akX;
                        hVar2.onStop();
                    }
                }
            }
        }
    }
}
