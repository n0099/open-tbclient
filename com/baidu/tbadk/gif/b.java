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
    final /* synthetic */ GifView atB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.atB = gifView;
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
        weakReference = this.atB.atf;
        if (weakReference != null) {
            weakReference2 = this.atB.atf;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null && message.what == 1) {
                GifView gifView = this.atB;
                i = gifView.atg;
                gifView.atg = i + 1;
                i2 = this.atB.atg;
                if (i2 >= bVar.fi()) {
                    z2 = this.atB.atw;
                    if (z2) {
                        this.atB.setVisibility(4);
                        this.atB.atw = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    this.atB.atg = 0;
                } else {
                    z = false;
                }
                i3 = this.atB.atg;
                bVar.F(i3);
                bitmap = this.atB.mBitmap;
                bVar.a(bitmap, null);
                this.atB.invalidate();
                removeMessages(1);
                if (!z) {
                    i4 = this.atB.atg;
                    sendEmptyMessageDelayed(1, bVar.G(i4));
                    return;
                }
                aVar = this.atB.ath;
                if (aVar != null) {
                    aVar2 = this.atB.ath;
                    aVar2.onStop();
                }
            }
        }
    }
}
