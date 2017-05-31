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
    final /* synthetic */ GiftGifView aCE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.aCE = giftGifView;
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
        weakReference = this.aCE.aCA;
        if (weakReference != null) {
            weakReference2 = this.aCE.aCA;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.aCE.aCD = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.aCE;
                    i = giftGifView.aCe;
                    giftGifView.aCe = i + 1;
                    i2 = this.aCE.aCe;
                    if (i2 >= bVar.dE()) {
                        z2 = this.aCE.aCw;
                        if (!z2) {
                            z3 = this.aCE.aCD;
                            if (!z3) {
                                z = false;
                                this.aCE.aCe = 0;
                            }
                        }
                        this.aCE.setVisibility(4);
                        this.aCE.aCw = false;
                        z = true;
                        this.aCE.aCe = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.aCE.aCe;
                    bVar.T(i3);
                    bitmap = this.aCE.mBitmap;
                    bVar.a(bitmap, null);
                    this.aCE.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.aCE.aCe;
                        sendEmptyMessageDelayed(1, bVar.U(i4));
                        return;
                    }
                    aVar = this.aCE.aCB;
                    if (aVar != null) {
                        aVar2 = this.aCE.aCB;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
