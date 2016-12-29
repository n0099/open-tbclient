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
    final /* synthetic */ GiftGifView ayk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.ayk = giftGifView;
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
        weakReference = this.ayk.ayg;
        if (weakReference != null) {
            weakReference2 = this.ayk.ayg;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.ayk.ayj = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.ayk;
                    i = giftGifView.axI;
                    giftGifView.axI = i + 1;
                    i2 = this.ayk.axI;
                    if (i2 >= bVar.cx()) {
                        z2 = this.ayk.aya;
                        if (!z2) {
                            z3 = this.ayk.ayj;
                            if (!z3) {
                                z = false;
                                this.ayk.axI = 0;
                            }
                        }
                        this.ayk.setVisibility(4);
                        this.ayk.aya = false;
                        z = true;
                        this.ayk.axI = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.ayk.axI;
                    bVar.V(i3);
                    bitmap = this.ayk.mBitmap;
                    bVar.a(bitmap, null);
                    this.ayk.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.ayk.axI;
                        sendEmptyMessageDelayed(1, bVar.W(i4));
                        return;
                    }
                    aVar = this.ayk.ayh;
                    if (aVar != null) {
                        aVar2 = this.ayk.ayh;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
