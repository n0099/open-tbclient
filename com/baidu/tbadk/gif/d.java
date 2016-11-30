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
    final /* synthetic */ GiftGifView ayN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.ayN = giftGifView;
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
        weakReference = this.ayN.ayJ;
        if (weakReference != null) {
            weakReference2 = this.ayN.ayJ;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.ayN.ayM = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.ayN;
                    i = giftGifView.ayl;
                    giftGifView.ayl = i + 1;
                    i2 = this.ayN.ayl;
                    if (i2 >= bVar.cx()) {
                        z2 = this.ayN.ayD;
                        if (!z2) {
                            z3 = this.ayN.ayM;
                            if (!z3) {
                                z = false;
                                this.ayN.ayl = 0;
                            }
                        }
                        this.ayN.setVisibility(4);
                        this.ayN.ayD = false;
                        z = true;
                        this.ayN.ayl = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.ayN.ayl;
                    bVar.U(i3);
                    bitmap = this.ayN.mBitmap;
                    bVar.a(bitmap, null);
                    this.ayN.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.ayN.ayl;
                        sendEmptyMessageDelayed(1, bVar.V(i4));
                        return;
                    }
                    aVar = this.ayN.ayK;
                    if (aVar != null) {
                        aVar2 = this.ayN.ayK;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
