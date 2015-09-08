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
    final /* synthetic */ GifView avl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.avl = gifView;
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
        weakReference = this.avl.auP;
        if (weakReference != null) {
            weakReference2 = this.avl.auP;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null && message.what == 1) {
                GifView gifView = this.avl;
                i = gifView.auQ;
                gifView.auQ = i + 1;
                i2 = this.avl.auQ;
                if (i2 >= bVar.ff()) {
                    z2 = this.avl.avg;
                    if (z2) {
                        this.avl.setVisibility(4);
                        this.avl.avg = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    this.avl.auQ = 0;
                } else {
                    z = false;
                }
                i3 = this.avl.auQ;
                bVar.F(i3);
                bitmap = this.avl.mBitmap;
                bVar.a(bitmap, null);
                this.avl.invalidate();
                removeMessages(1);
                if (!z) {
                    i4 = this.avl.auQ;
                    sendEmptyMessageDelayed(1, bVar.G(i4));
                    return;
                }
                aVar = this.avl.auR;
                if (aVar != null) {
                    aVar2 = this.avl.auR;
                    aVar2.onStop();
                }
            }
        }
    }
}
