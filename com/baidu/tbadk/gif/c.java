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
    final /* synthetic */ GiftGifView aDI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.aDI = giftGifView;
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
        weakReference = this.aDI.aDE;
        if (weakReference != null) {
            weakReference2 = this.aDI.aDE;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.aDI.aDH = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.aDI;
                    i = giftGifView.aDh;
                    giftGifView.aDh = i + 1;
                    i2 = this.aDI.aDh;
                    if (i2 >= bVar.dE()) {
                        z2 = this.aDI.aDA;
                        if (!z2) {
                            z3 = this.aDI.aDH;
                            if (!z3) {
                                z = false;
                                this.aDI.aDh = 0;
                            }
                        }
                        this.aDI.setVisibility(4);
                        this.aDI.aDA = false;
                        z = true;
                        this.aDI.aDh = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.aDI.aDh;
                    bVar.T(i3);
                    bitmap = this.aDI.mBitmap;
                    bVar.a(bitmap, null);
                    this.aDI.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.aDI.aDh;
                        sendEmptyMessageDelayed(1, bVar.U(i4));
                        return;
                    }
                    aVar = this.aDI.aDF;
                    if (aVar != null) {
                        aVar2 = this.aDI.aDF;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
