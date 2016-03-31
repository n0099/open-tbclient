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
    final /* synthetic */ GiftGifView axG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.axG = giftGifView;
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
        weakReference = this.axG.axC;
        if (weakReference != null) {
            weakReference2 = this.axG.axC;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.axG.axF = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.axG;
                    i = giftGifView.axe;
                    giftGifView.axe = i + 1;
                    i2 = this.axG.axe;
                    if (i2 >= bVar.fo()) {
                        z2 = this.axG.axw;
                        if (!z2) {
                            z3 = this.axG.axF;
                            if (!z3) {
                                z = false;
                                this.axG.axe = 0;
                            }
                        }
                        this.axG.setVisibility(4);
                        this.axG.axw = false;
                        z = true;
                        this.axG.axe = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.axG.axe;
                    bVar.Q(i3);
                    bitmap = this.axG.mBitmap;
                    bVar.a(bitmap, null);
                    this.axG.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.axG.axe;
                        sendEmptyMessageDelayed(1, bVar.R(i4));
                        return;
                    }
                    aVar = this.axG.axD;
                    if (aVar != null) {
                        aVar2 = this.axG.axD;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
