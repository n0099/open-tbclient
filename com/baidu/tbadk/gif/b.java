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
    final /* synthetic */ GifView atJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GifView gifView, Looper looper) {
        super(looper);
        this.atJ = gifView;
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
        weakReference = this.atJ.atn;
        if (weakReference != null) {
            weakReference2 = this.atJ.atn;
            com.baidu.adp.gif.b bVar = (com.baidu.adp.gif.b) weakReference2.get();
            if (bVar != null && message.what == 1) {
                GifView gifView = this.atJ;
                i = gifView.ato;
                gifView.ato = i + 1;
                i2 = this.atJ.ato;
                if (i2 >= bVar.ff()) {
                    z2 = this.atJ.atE;
                    if (z2) {
                        this.atJ.setVisibility(4);
                        this.atJ.atE = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    this.atJ.ato = 0;
                } else {
                    z = false;
                }
                i3 = this.atJ.ato;
                bVar.F(i3);
                bitmap = this.atJ.mBitmap;
                bVar.a(bitmap, null);
                this.atJ.invalidate();
                removeMessages(1);
                if (!z) {
                    i4 = this.atJ.ato;
                    sendEmptyMessageDelayed(1, bVar.G(i4));
                    return;
                }
                aVar = this.atJ.atp;
                if (aVar != null) {
                    aVar2 = this.atJ.atp;
                    aVar2.onStop();
                }
            }
        }
    }
}
