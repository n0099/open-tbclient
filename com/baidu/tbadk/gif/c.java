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
    final /* synthetic */ GiftGifView aCA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.aCA = giftGifView;
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
        weakReference = this.aCA.aCw;
        if (weakReference != null) {
            weakReference2 = this.aCA.aCw;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.aCA.aCz = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.aCA;
                    i = giftGifView.aCa;
                    giftGifView.aCa = i + 1;
                    i2 = this.aCA.aCa;
                    if (i2 >= bVar.dE()) {
                        z2 = this.aCA.aCs;
                        if (!z2) {
                            z3 = this.aCA.aCz;
                            if (!z3) {
                                z = false;
                                this.aCA.aCa = 0;
                            }
                        }
                        this.aCA.setVisibility(4);
                        this.aCA.aCs = false;
                        z = true;
                        this.aCA.aCa = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.aCA.aCa;
                    bVar.V(i3);
                    bitmap = this.aCA.mBitmap;
                    bVar.a(bitmap, null);
                    this.aCA.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.aCA.aCa;
                        sendEmptyMessageDelayed(1, bVar.W(i4));
                        return;
                    }
                    aVar = this.aCA.aCx;
                    if (aVar != null) {
                        aVar2 = this.aCA.aCx;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
