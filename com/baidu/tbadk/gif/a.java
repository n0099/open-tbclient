package com.baidu.tbadk.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.gif.c;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends Handler {
    final /* synthetic */ GifView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GifView gifView) {
        this.a = gifView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        WeakReference weakReference;
        WeakReference weakReference2;
        int i;
        int i2;
        Bitmap bitmap;
        int i3;
        weakReference = this.a.b;
        if (weakReference != null) {
            weakReference2 = this.a.b;
            c cVar = (c) weakReference2.get();
            if (cVar != null && message.what == 1) {
                GifView.a(this.a, 1);
                i = this.a.d;
                if (i >= cVar.e()) {
                    this.a.d = 0;
                }
                i2 = this.a.d;
                cVar.a(i2);
                bitmap = this.a.c;
                cVar.a(bitmap, null);
                this.a.invalidate();
                removeMessages(1);
                i3 = this.a.d;
                sendEmptyMessageDelayed(1, cVar.b(i3));
            }
        }
    }
}
