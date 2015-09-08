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
    final /* synthetic */ GiftGifView avp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(GiftGifView giftGifView, Looper looper) {
        super(looper);
        this.avp = giftGifView;
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
        weakReference = this.avp.auP;
        if (weakReference != null) {
            weakReference2 = this.avp.auP;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null) {
                if (message.what == 2) {
                    this.avp.avo = true;
                    removeMessages(2);
                } else if (message.what == 1) {
                    GiftGifView giftGifView = this.avp;
                    i = giftGifView.auQ;
                    giftGifView.auQ = i + 1;
                    i2 = this.avp.auQ;
                    if (i2 >= bVar.ff()) {
                        z2 = this.avp.avg;
                        if (!z2) {
                            z3 = this.avp.avo;
                            if (!z3) {
                                z = false;
                                this.avp.auQ = 0;
                            }
                        }
                        this.avp.setVisibility(4);
                        this.avp.avg = false;
                        z = true;
                        this.avp.auQ = 0;
                    } else {
                        z = false;
                    }
                    i3 = this.avp.auQ;
                    bVar.F(i3);
                    bitmap = this.avp.mBitmap;
                    bVar.a(bitmap, null);
                    this.avp.invalidate();
                    removeMessages(1);
                    if (!z) {
                        i4 = this.avp.auQ;
                        sendEmptyMessageDelayed(1, bVar.G(i4));
                        return;
                    }
                    aVar = this.avp.avm;
                    if (aVar != null) {
                        aVar2 = this.avp.avm;
                        aVar2.onStop();
                    }
                }
            }
        }
    }
}
