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
    final /* synthetic */ GiftGifView ays;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.ays = giftGifView;
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
        weakReference = this.ays.ayo;
        if (weakReference != null) {
            weakReference2 = this.ays.ayo;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.ays.ayr = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.ays;
                    i = giftGifView.axR;
                    giftGifView.axR = i + 1;
                    i2 = this.ays.axR;
                    if (i2 >= bVar.cx()) {
                        z2 = this.ays.ayj;
                        if (!z2) {
                            z3 = this.ays.ayr;
                            if (!z3) {
                                z = false;
                                this.ays.axR = 0;
                            }
                        }
                        this.ays.setVisibility(4);
                        this.ays.ayj = false;
                        z = true;
                        this.ays.axR = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.ays.axR;
                    bVar.U(i3);
                    bitmap = this.ays.mBitmap;
                    bVar.a(bitmap, null);
                    this.ays.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.ays.axR;
                        sendEmptyMessageDelayed(1, bVar.V(i4));
                        return;
                    }
                    aVar = this.ays.ayp;
                    if (aVar != null) {
                        aVar2 = this.ays.ayp;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
