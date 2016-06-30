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
    final /* synthetic */ GiftGifView auw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.auw = giftGifView;
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
        weakReference = this.auw.aus;
        if (weakReference != null) {
            weakReference2 = this.auw.aus;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.auw.auv = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.auw;
                    i = giftGifView.atV;
                    giftGifView.atV = i + 1;
                    i2 = this.auw.atV;
                    if (i2 >= bVar.bD()) {
                        z2 = this.auw.aun;
                        if (!z2) {
                            z3 = this.auw.auv;
                            if (!z3) {
                                z = false;
                                this.auw.atV = 0;
                            }
                        }
                        this.auw.setVisibility(4);
                        this.auw.aun = false;
                        z = true;
                        this.auw.atV = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.auw.atV;
                    bVar.E(i3);
                    bitmap = this.auw.mBitmap;
                    bVar.a(bitmap, null);
                    this.auw.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.auw.atV;
                        sendEmptyMessageDelayed(1, bVar.F(i4));
                        return;
                    }
                    aVar = this.auw.aut;
                    if (aVar != null) {
                        aVar2 = this.auw.aut;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
