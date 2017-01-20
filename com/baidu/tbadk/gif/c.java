package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tbadk.gif.GiftGifView;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {
    final /* synthetic */ GiftGifView axg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.axg = giftGifView;
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
        weakReference = this.axg.axc;
        if (weakReference != null) {
            weakReference2 = this.axg.axc;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.axg.axf = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.axg;
                    i = giftGifView.awG;
                    giftGifView.awG = i + 1;
                    i2 = this.axg.awG;
                    if (i2 >= bVar.cv()) {
                        z2 = this.axg.awY;
                        if (!z2) {
                            z3 = this.axg.axf;
                            if (!z3) {
                                z = false;
                                this.axg.awG = 0;
                            }
                        }
                        this.axg.setVisibility(4);
                        this.axg.awY = false;
                        z = true;
                        this.axg.awG = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.axg.awG;
                    bVar.V(i3);
                    bitmap = this.axg.mBitmap;
                    bVar.a(bitmap, null);
                    this.axg.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.axg.awG;
                        sendEmptyMessageDelayed(1, bVar.W(i4));
                        return;
                    }
                    aVar = this.axg.axd;
                    if (aVar != null) {
                        aVar2 = this.axg.axd;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
