package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Handler {
    final /* synthetic */ GiftGifView akS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.akS = giftGifView;
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
        weakReference = this.akS.aks;
        if (weakReference != null) {
            weakReference2 = this.akS.aks;
            com.baidu.adp.gif.c cVar = (com.baidu.adp.gif.c) weakReference2.get();
            if (cVar != null) {
                if (message.what == 2) {
                    this.akS.akR = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.akS;
                    i = giftGifView.akt;
                    giftGifView.akt = i + 1;
                    i2 = this.akS.akt;
                    if (i2 >= cVar.fg()) {
                        z2 = this.akS.akJ;
                        if (!z2) {
                            z3 = this.akS.akR;
                            if (!z3) {
                                z = false;
                                this.akS.akt = 0;
                            }
                        }
                        this.akS.setVisibility(4);
                        this.akS.akJ = false;
                        z = true;
                        this.akS.akt = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.akS.akt;
                    cVar.C(i3);
                    bitmap = this.akS.mBitmap;
                    cVar.a(bitmap, null);
                    this.akS.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.akS.akt;
                        sendEmptyMessageDelayed(1, cVar.D(i4));
                        return;
                    }
                    hVar = this.akS.akP;
                    if (hVar != null) {
                        hVar2 = this.akS.akP;
                        hVar2.onStop();
                    }
                }
            }
        }
    }
}
