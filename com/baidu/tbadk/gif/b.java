package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView TJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.TJ = gifView;
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
        d dVar;
        d dVar2;
        int i4;
        boolean z2;
        weakReference = this.TJ.Tn;
        if (weakReference != null) {
            weakReference2 = this.TJ.Tn;
            com.baidu.adp.gif.c cVar = (com.baidu.adp.gif.c) weakReference2.get();
            if (cVar != null && message.what == 1) {
                GifView gifView = this.TJ;
                i = gifView.To;
                gifView.To = i + 1;
                i2 = this.TJ.To;
                if (i2 >= cVar.bj()) {
                    z2 = this.TJ.TE;
                    if (z2) {
                        this.TJ.setVisibility(4);
                        this.TJ.TE = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    this.TJ.To = 0;
                } else {
                    z = false;
                }
                i3 = this.TJ.To;
                cVar.k(i3);
                bitmap = this.TJ.mBitmap;
                cVar.a(bitmap, null);
                this.TJ.invalidate();
                removeMessages(1);
                if (!z) {
                    i4 = this.TJ.To;
                    sendEmptyMessageDelayed(1, cVar.l(i4));
                    return;
                }
                dVar = this.TJ.Tp;
                if (dVar != null) {
                    dVar2 = this.TJ.Tp;
                    dVar2.onStop();
                }
            }
        }
    }
}
