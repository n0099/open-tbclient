package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tbadk.gif.GifView;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView atI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.atI = gifView;
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
        GifView.a aVar;
        GifView.a aVar2;
        int i4;
        boolean z2;
        weakReference = this.atI.atm;
        if (weakReference != null) {
            weakReference2 = this.atI.atm;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null && message.what == 1) {
                GifView gifView = this.atI;
                i = gifView.atn;
                gifView.atn = i + 1;
                i2 = this.atI.atn;
                if (i2 >= bVar.ff()) {
                    z2 = this.atI.atD;
                    if (z2) {
                        this.atI.setVisibility(4);
                        this.atI.atD = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    this.atI.atn = 0;
                } else {
                    z = false;
                }
                i3 = this.atI.atn;
                bVar.F(i3);
                bitmap = this.atI.mBitmap;
                bVar.a(bitmap, null);
                this.atI.invalidate();
                removeMessages(1);
                if (!z) {
                    i4 = this.atI.atn;
                    sendEmptyMessageDelayed(1, bVar.G(i4));
                    return;
                }
                aVar = this.atI.ato;
                if (aVar != null) {
                    aVar2 = this.atI.ato;
                    aVar2.onStop();
                }
            }
        }
    }
}
