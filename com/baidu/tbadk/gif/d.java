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
    final /* synthetic */ GiftGifView atF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.atF = giftGifView;
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
        weakReference = this.atF.atf;
        if (weakReference != null) {
            weakReference2 = this.atF.atf;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.atF.atE = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.atF;
                    i = giftGifView.atg;
                    giftGifView.atg = i + 1;
                    i2 = this.atF.atg;
                    if (i2 >= bVar.fi()) {
                        z2 = this.atF.atw;
                        if (!z2) {
                            z3 = this.atF.atE;
                            if (!z3) {
                                z = false;
                                this.atF.atg = 0;
                            }
                        }
                        this.atF.setVisibility(4);
                        this.atF.atw = false;
                        z = true;
                        this.atF.atg = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.atF.atg;
                    bVar.F(i3);
                    bitmap = this.atF.mBitmap;
                    bVar.a(bitmap, null);
                    this.atF.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.atF.atg;
                        sendEmptyMessageDelayed(1, bVar.G(i4));
                        return;
                    }
                    aVar = this.atF.atC;
                    if (aVar != null) {
                        aVar2 = this.atF.atC;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
