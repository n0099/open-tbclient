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
    final /* synthetic */ GiftGifView aCR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.aCR = giftGifView;
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
        weakReference = this.aCR.aCN;
        if (weakReference != null) {
            weakReference2 = this.aCR.aCN;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.aCR.aCQ = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.aCR;
                    i = giftGifView.aCr;
                    giftGifView.aCr = i + 1;
                    i2 = this.aCR.aCr;
                    if (i2 >= bVar.dE()) {
                        z2 = this.aCR.aCJ;
                        if (!z2) {
                            z3 = this.aCR.aCQ;
                            if (!z3) {
                                z = false;
                                this.aCR.aCr = 0;
                            }
                        }
                        this.aCR.setVisibility(4);
                        this.aCR.aCJ = false;
                        z = true;
                        this.aCR.aCr = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.aCR.aCr;
                    bVar.T(i3);
                    bitmap = this.aCR.mBitmap;
                    bVar.a(bitmap, null);
                    this.aCR.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.aCR.aCr;
                        sendEmptyMessageDelayed(1, bVar.U(i4));
                        return;
                    }
                    aVar = this.aCR.aCO;
                    if (aVar != null) {
                        aVar2 = this.aCR.aCO;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
