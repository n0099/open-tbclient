package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends Handler {
    final /* synthetic */ GiftGifView TN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.TN = giftGifView;
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
        g gVar;
        g gVar2;
        int i4;
        boolean z2;
        boolean z3;
        weakReference = this.TN.Tn;
        if (weakReference != null) {
            weakReference2 = this.TN.Tn;
            com.baidu.adp.gif.c cVar = (com.baidu.adp.gif.c) weakReference2.get();
            if (cVar != null) {
                if (message.what == 2) {
                    this.TN.TM = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.TN;
                    i = giftGifView.To;
                    giftGifView.To = i + 1;
                    i2 = this.TN.To;
                    if (i2 >= cVar.bj()) {
                        z2 = this.TN.TE;
                        if (!z2) {
                            z3 = this.TN.TM;
                            if (!z3) {
                                z = false;
                                this.TN.To = 0;
                            }
                        }
                        this.TN.setVisibility(4);
                        this.TN.TE = false;
                        z = true;
                        this.TN.To = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.TN.To;
                    cVar.k(i3);
                    bitmap = this.TN.mBitmap;
                    cVar.a(bitmap, null);
                    this.TN.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.TN.To;
                        sendEmptyMessageDelayed(1, cVar.l(i4));
                        return;
                    }
                    gVar = this.TN.TK;
                    if (gVar != null) {
                        gVar2 = this.TN.TK;
                        gVar2.onStop();
                    }
                }
            }
        }
    }
}
