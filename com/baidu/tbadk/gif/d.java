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
    final /* synthetic */ GiftGifView atM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.atM = giftGifView;
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
        weakReference = this.atM.atm;
        if (weakReference != null) {
            weakReference2 = this.atM.atm;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.atM.atL = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.atM;
                    i = giftGifView.atn;
                    giftGifView.atn = i + 1;
                    i2 = this.atM.atn;
                    if (i2 >= bVar.ff()) {
                        z2 = this.atM.atD;
                        if (!z2) {
                            z3 = this.atM.atL;
                            if (!z3) {
                                z = false;
                                this.atM.atn = 0;
                            }
                        }
                        this.atM.setVisibility(4);
                        this.atM.atD = false;
                        z = true;
                        this.atM.atn = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.atM.atn;
                    bVar.F(i3);
                    bitmap = this.atM.mBitmap;
                    bVar.a(bitmap, null);
                    this.atM.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.atM.atn;
                        sendEmptyMessageDelayed(1, bVar.G(i4));
                        return;
                    }
                    aVar = this.atM.atJ;
                    if (aVar != null) {
                        aVar2 = this.atM.atJ;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
