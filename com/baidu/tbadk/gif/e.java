package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends Handler {
    final /* synthetic */ GiftGifView TR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.TR = giftGifView;
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
        weakReference = this.TR.Tr;
        if (weakReference != null) {
            weakReference2 = this.TR.Tr;
            com.baidu.adp.gif.c cVar = (com.baidu.adp.gif.c) weakReference2.get();
            if (cVar != null) {
                if (message.what == 2) {
                    this.TR.TQ = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.TR;
                    i = giftGifView.Ts;
                    giftGifView.Ts = i + 1;
                    i2 = this.TR.Ts;
                    if (i2 >= cVar.bj()) {
                        z2 = this.TR.TI;
                        if (!z2) {
                            z3 = this.TR.TQ;
                            if (!z3) {
                                z = false;
                                this.TR.Ts = 0;
                            }
                        }
                        this.TR.setVisibility(4);
                        this.TR.TI = false;
                        z = true;
                        this.TR.Ts = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.TR.Ts;
                    cVar.k(i3);
                    bitmap = this.TR.mBitmap;
                    cVar.a(bitmap, null);
                    this.TR.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.TR.Ts;
                        sendEmptyMessageDelayed(1, cVar.l(i4));
                        return;
                    }
                    gVar = this.TR.TO;
                    if (gVar != null) {
                        gVar2 = this.TR.TO;
                        gVar2.onStop();
                    }
                }
            }
        }
    }
}
