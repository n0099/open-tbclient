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
    final /* synthetic */ GiftGifView asB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.asB = giftGifView;
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
        weakReference = this.asB.asb;
        if (weakReference != null) {
            weakReference2 = this.asB.asb;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.asB.asA = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.asB;
                    i = giftGifView.asc;
                    giftGifView.asc = i + 1;
                    i2 = this.asB.asc;
                    if (i2 >= bVar.ff()) {
                        z2 = this.asB.ass;
                        if (!z2) {
                            z3 = this.asB.asA;
                            if (!z3) {
                                z = false;
                                this.asB.asc = 0;
                            }
                        }
                        this.asB.setVisibility(4);
                        this.asB.ass = false;
                        z = true;
                        this.asB.asc = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.asB.asc;
                    bVar.F(i3);
                    bitmap = this.asB.mBitmap;
                    bVar.a(bitmap, null);
                    this.asB.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.asB.asc;
                        sendEmptyMessageDelayed(1, bVar.G(i4));
                        return;
                    }
                    aVar = this.asB.asy;
                    if (aVar != null) {
                        aVar2 = this.asB.asy;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
