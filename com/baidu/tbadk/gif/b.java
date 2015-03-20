package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView akO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.akO = gifView;
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
        e eVar;
        e eVar2;
        int i4;
        boolean z2;
        weakReference = this.akO.aks;
        if (weakReference != null) {
            weakReference2 = this.akO.aks;
            com.baidu.adp.gif.c cVar = (com.baidu.adp.gif.c) weakReference2.get();
            if (cVar != null && message.what == 1) {
                GifView gifView = this.akO;
                i = gifView.akt;
                gifView.akt = i + 1;
                i2 = this.akO.akt;
                if (i2 >= cVar.fg()) {
                    z2 = this.akO.akJ;
                    if (z2) {
                        this.akO.setVisibility(4);
                        this.akO.akJ = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    this.akO.akt = 0;
                } else {
                    z = false;
                }
                i3 = this.akO.akt;
                cVar.C(i3);
                bitmap = this.akO.mBitmap;
                cVar.a(bitmap, null);
                this.akO.invalidate();
                removeMessages(1);
                if (!z) {
                    i4 = this.akO.akt;
                    sendEmptyMessageDelayed(1, cVar.D(i4));
                    return;
                }
                eVar = this.akO.aku;
                if (eVar != null) {
                    eVar2 = this.akO.aku;
                    eVar2.onStop();
                }
            }
        }
    }
}
