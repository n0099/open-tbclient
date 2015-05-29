package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends Handler {
    final /* synthetic */ GiftGifView amb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.amb = giftGifView;
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
        g gVar;
        g gVar2;
        int i4;
        boolean z2;
        boolean z3;
        weakReference = this.amb.alB;
        if (weakReference != null) {
            weakReference2 = this.amb.alB;
            com.baidu.adp.gif.c cVar = (com.baidu.adp.gif.c) weakReference2.get();
            if (cVar != null) {
                if (message.what == 2) {
                    this.amb.ama = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.amb;
                    i = giftGifView.alC;
                    giftGifView.alC = i + 1;
                    i2 = this.amb.alC;
                    if (i2 >= cVar.fl()) {
                        z2 = this.amb.alS;
                        if (!z2) {
                            z3 = this.amb.ama;
                            if (!z3) {
                                z = false;
                                this.amb.alC = 0;
                            }
                        }
                        this.amb.setVisibility(4);
                        this.amb.alS = false;
                        z = true;
                        this.amb.alC = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.amb.alC;
                    cVar.D(i3);
                    bitmap = this.amb.mBitmap;
                    cVar.a(bitmap, null);
                    this.amb.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.amb.alC;
                        sendEmptyMessageDelayed(1, cVar.E(i4));
                        return;
                    }
                    gVar = this.amb.alY;
                    if (gVar != null) {
                        gVar2 = this.amb.alY;
                        gVar2.onStop();
                    }
                }
            }
        }
    }
}
