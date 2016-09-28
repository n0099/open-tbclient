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
    final /* synthetic */ GiftGifView axV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.axV = giftGifView;
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
        weakReference = this.axV.axR;
        if (weakReference != null) {
            weakReference2 = this.axV.axR;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.axV.axU = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.axV;
                    i = giftGifView.axu;
                    giftGifView.axu = i + 1;
                    i2 = this.axV.axu;
                    if (i2 >= bVar.cx()) {
                        z2 = this.axV.axM;
                        if (!z2) {
                            z3 = this.axV.axU;
                            if (!z3) {
                                z = false;
                                this.axV.axu = 0;
                            }
                        }
                        this.axV.setVisibility(4);
                        this.axV.axM = false;
                        z = true;
                        this.axV.axu = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.axV.axu;
                    bVar.U(i3);
                    bitmap = this.axV.mBitmap;
                    bVar.a(bitmap, null);
                    this.axV.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.axV.axu;
                        sendEmptyMessageDelayed(1, bVar.V(i4));
                        return;
                    }
                    aVar = this.axV.axS;
                    if (aVar != null) {
                        aVar2 = this.axV.axS;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
