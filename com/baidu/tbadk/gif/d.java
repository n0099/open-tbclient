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
    final /* synthetic */ GiftGifView avl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.avl = giftGifView;
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
        weakReference = this.avl.avh;
        if (weakReference != null) {
            weakReference2 = this.avl.avh;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.avl.avk = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.avl;
                    i = giftGifView.auK;
                    giftGifView.auK = i + 1;
                    i2 = this.avl.auK;
                    if (i2 >= bVar.bC()) {
                        z2 = this.avl.avc;
                        if (!z2) {
                            z3 = this.avl.avk;
                            if (!z3) {
                                z = false;
                                this.avl.auK = 0;
                            }
                        }
                        this.avl.setVisibility(4);
                        this.avl.avc = false;
                        z = true;
                        this.avl.auK = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.avl.auK;
                    bVar.H(i3);
                    bitmap = this.avl.mBitmap;
                    bVar.a(bitmap, null);
                    this.avl.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.avl.auK;
                        sendEmptyMessageDelayed(1, bVar.I(i4));
                        return;
                    }
                    aVar = this.avl.avi;
                    if (aVar != null) {
                        aVar2 = this.avl.avi;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
