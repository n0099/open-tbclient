package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Handler {
    final /* synthetic */ GiftGifView ZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.ZW = giftGifView;
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
        h hVar;
        h hVar2;
        int i4;
        boolean z2;
        boolean z3;
        weakReference = this.ZW.Zw;
        if (weakReference != null) {
            weakReference2 = this.ZW.Zw;
            com.baidu.adp.gif.c cVar = (com.baidu.adp.gif.c) weakReference2.get();
            if (cVar != null) {
                if (message.what == 2) {
                    this.ZW.ZV = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.ZW;
                    i = giftGifView.Zx;
                    giftGifView.Zx = i + 1;
                    i2 = this.ZW.Zx;
                    if (i2 >= cVar.bK()) {
                        z2 = this.ZW.ZN;
                        if (!z2) {
                            z3 = this.ZW.ZV;
                            if (!z3) {
                                z = false;
                                this.ZW.Zx = 0;
                            }
                        }
                        this.ZW.setVisibility(4);
                        this.ZW.ZN = false;
                        z = true;
                        this.ZW.Zx = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.ZW.Zx;
                    cVar.w(i3);
                    bitmap = this.ZW.mBitmap;
                    cVar.a(bitmap, null);
                    this.ZW.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.ZW.Zx;
                        sendEmptyMessageDelayed(1, cVar.x(i4));
                        return;
                    }
                    hVar = this.ZW.ZT;
                    if (hVar != null) {
                        hVar2 = this.ZW.ZT;
                        hVar2.onStop();
                    }
                }
            }
        }
    }
}
