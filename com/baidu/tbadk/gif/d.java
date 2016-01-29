package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tbadk.gif.GiftGifView;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ GiftGifView awZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.awZ = giftGifView;
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
        weakReference = this.awZ.awV;
        if (weakReference != null) {
            weakReference2 = this.awZ.awV;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.awZ.awY = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.awZ;
                    i = giftGifView.awx;
                    giftGifView.awx = i + 1;
                    i2 = this.awZ.awx;
                    if (i2 >= bVar.fn()) {
                        z2 = this.awZ.awP;
                        if (!z2) {
                            z3 = this.awZ.awY;
                            if (!z3) {
                                z = false;
                                this.awZ.awx = 0;
                            }
                        }
                        this.awZ.setVisibility(4);
                        this.awZ.awP = false;
                        z = true;
                        this.awZ.awx = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.awZ.awx;
                    bVar.R(i3);
                    bitmap = this.awZ.mBitmap;
                    bVar.a(bitmap, null);
                    this.awZ.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.awZ.awx;
                        sendEmptyMessageDelayed(1, bVar.S(i4));
                        return;
                    }
                    aVar = this.awZ.awW;
                    if (aVar != null) {
                        aVar2 = this.awZ.awW;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
