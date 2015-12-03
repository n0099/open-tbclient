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
    final /* synthetic */ GiftGifView auE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.auE = giftGifView;
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
        weakReference = this.auE.auA;
        if (weakReference != null) {
            weakReference2 = this.auE.auA;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.auE.auD = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.auE;
                    i = giftGifView.auc;
                    giftGifView.auc = i + 1;
                    i2 = this.auE.auc;
                    if (i2 >= bVar.ff()) {
                        z2 = this.auE.auu;
                        if (!z2) {
                            z3 = this.auE.auD;
                            if (!z3) {
                                z = false;
                                this.auE.auc = 0;
                            }
                        }
                        this.auE.setVisibility(4);
                        this.auE.auu = false;
                        z = true;
                        this.auE.auc = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.auE.auc;
                    bVar.G(i3);
                    bitmap = this.auE.mBitmap;
                    bVar.a(bitmap, null);
                    this.auE.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.auE.auc;
                        sendEmptyMessageDelayed(1, bVar.H(i4));
                        return;
                    }
                    aVar = this.auE.auB;
                    if (aVar != null) {
                        aVar2 = this.auE.auB;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
