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
    final /* synthetic */ GiftGifView atH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.atH = giftGifView;
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
        weakReference = this.atH.atD;
        if (weakReference != null) {
            weakReference2 = this.atH.atD;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.atH.atG = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.atH;
                    i = giftGifView.atf;
                    giftGifView.atf = i + 1;
                    i2 = this.atH.atf;
                    if (i2 >= bVar.bC()) {
                        z2 = this.atH.atx;
                        if (!z2) {
                            z3 = this.atH.atG;
                            if (!z3) {
                                z = false;
                                this.atH.atf = 0;
                            }
                        }
                        this.atH.setVisibility(4);
                        this.atH.atx = false;
                        z = true;
                        this.atH.atf = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.atH.atf;
                    bVar.E(i3);
                    bitmap = this.atH.mBitmap;
                    bVar.a(bitmap, null);
                    this.atH.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.atH.atf;
                        sendEmptyMessageDelayed(1, bVar.F(i4));
                        return;
                    }
                    aVar = this.atH.atE;
                    if (aVar != null) {
                        aVar2 = this.atH.atE;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
