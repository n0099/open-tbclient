package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tbadk.gif.GiftGifView;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {
    final /* synthetic */ GiftGifView aCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.aCQ = giftGifView;
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
        GiftGifView.a aVar;
        GiftGifView.a aVar2;
        int i4;
        boolean z2;
        boolean z3;
        weakReference = this.aCQ.aCM;
        if (weakReference != null) {
            weakReference2 = this.aCQ.aCM;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.aCQ.aCP = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.aCQ;
                    i = giftGifView.aCq;
                    giftGifView.aCq = i + 1;
                    i2 = this.aCQ.aCq;
                    if (i2 >= bVar.dD()) {
                        z2 = this.aCQ.aCI;
                        if (!z2) {
                            z3 = this.aCQ.aCP;
                            if (!z3) {
                                z = false;
                                this.aCQ.aCq = 0;
                            }
                        }
                        this.aCQ.setVisibility(4);
                        this.aCQ.aCI = false;
                        z = true;
                        this.aCQ.aCq = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.aCQ.aCq;
                    bVar.T(i3);
                    bitmap = this.aCQ.mBitmap;
                    bVar.a(bitmap, null);
                    this.aCQ.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.aCQ.aCq;
                        sendEmptyMessageDelayed(1, bVar.U(i4));
                        return;
                    }
                    aVar = this.aCQ.aCN;
                    if (aVar != null) {
                        aVar2 = this.aCQ.aCN;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
