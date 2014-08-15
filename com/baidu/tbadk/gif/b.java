package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ GifView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.a = gifView;
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
        weakReference = this.a.d;
        if (weakReference != null) {
            weakReference2 = this.a.d;
            com.baidu.adp.gif.c cVar = (com.baidu.adp.gif.c) weakReference2.get();
            if (cVar != null && message.what == 1) {
                GifView gifView = this.a;
                i = gifView.f;
                gifView.f = i + 1;
                i2 = this.a.f;
                if (i2 >= cVar.d()) {
                    z2 = this.a.w;
                    if (z2) {
                        this.a.setVisibility(4);
                        this.a.w = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    this.a.f = 0;
                } else {
                    z = false;
                }
                i3 = this.a.f;
                cVar.a(i3);
                bitmap = this.a.e;
                cVar.a(bitmap, null);
                this.a.invalidate();
                removeMessages(1);
                if (!z) {
                    i4 = this.a.f;
                    sendEmptyMessageDelayed(1, cVar.b(i4));
                    return;
                }
                dVar = this.a.g;
                if (dVar != null) {
                    dVar2 = this.a.g;
                    dVar2.a();
                }
            }
        }
    }
}
