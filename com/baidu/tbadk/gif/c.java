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
    final /* synthetic */ GiftGifView aCS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.aCS = giftGifView;
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
        weakReference = this.aCS.aCO;
        if (weakReference != null) {
            weakReference2 = this.aCS.aCO;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.aCS.aCR = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.aCS;
                    i = giftGifView.aCs;
                    giftGifView.aCs = i + 1;
                    i2 = this.aCS.aCs;
                    if (i2 >= bVar.dE()) {
                        z2 = this.aCS.aCK;
                        if (!z2) {
                            z3 = this.aCS.aCR;
                            if (!z3) {
                                z = false;
                                this.aCS.aCs = 0;
                            }
                        }
                        this.aCS.setVisibility(4);
                        this.aCS.aCK = false;
                        z = true;
                        this.aCS.aCs = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.aCS.aCs;
                    bVar.T(i3);
                    bitmap = this.aCS.mBitmap;
                    bVar.a(bitmap, null);
                    this.aCS.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.aCS.aCs;
                        sendEmptyMessageDelayed(1, bVar.U(i4));
                        return;
                    }
                    aVar = this.aCS.aCP;
                    if (aVar != null) {
                        aVar2 = this.aCS.aCP;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
