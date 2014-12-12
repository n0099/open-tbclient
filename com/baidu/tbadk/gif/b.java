package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView ZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.ZS = gifView;
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
        weakReference = this.ZS.Zw;
        if (weakReference != null) {
            weakReference2 = this.ZS.Zw;
            com.baidu.adp.gif.c cVar = (com.baidu.adp.gif.c) weakReference2.get();
            if (cVar != null && message.what == 1) {
                GifView gifView = this.ZS;
                i = gifView.Zx;
                gifView.Zx = i + 1;
                i2 = this.ZS.Zx;
                if (i2 >= cVar.bK()) {
                    z2 = this.ZS.ZN;
                    if (z2) {
                        this.ZS.setVisibility(4);
                        this.ZS.ZN = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    this.ZS.Zx = 0;
                } else {
                    z = false;
                }
                i3 = this.ZS.Zx;
                cVar.w(i3);
                bitmap = this.ZS.mBitmap;
                cVar.a(bitmap, null);
                this.ZS.invalidate();
                removeMessages(1);
                if (!z) {
                    i4 = this.ZS.Zx;
                    sendEmptyMessageDelayed(1, cVar.x(i4));
                    return;
                }
                eVar = this.ZS.Zy;
                if (eVar != null) {
                    eVar2 = this.ZS.Zy;
                    eVar2.onStop();
                }
            }
        }
    }
}
