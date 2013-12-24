package com.baidu.tieba.im.net;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        int i;
        int[] iArr;
        int i2;
        int[] iArr2;
        int[] iArr3;
        int i3;
        Handler handler2;
        Handler handler3;
        int[] iArr4;
        int i4;
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                handler = this.a.d;
                handler.removeMessages(1);
                StringBuilder append = new StringBuilder().append("this is reconn time:");
                i = this.a.b;
                be.b(append.append(i).toString());
                TiebaSocketLinkService.a(true, "time to reconnStragety");
                b.c(this.a);
                iArr = this.a.c;
                if (iArr != null) {
                    i2 = this.a.b;
                    iArr2 = this.a.c;
                    if (i2 < iArr2.length) {
                        StringBuilder append2 = new StringBuilder().append("Next will be delay:");
                        iArr3 = this.a.c;
                        i3 = this.a.b;
                        be.b(append2.append(iArr3[i3]).toString());
                        handler2 = this.a.d;
                        handler3 = this.a.d;
                        Message obtainMessage = handler3.obtainMessage(1);
                        iArr4 = this.a.c;
                        i4 = this.a.b;
                        handler2.sendMessageDelayed(obtainMessage, iArr4[i4] * LocationClientOption.MIN_SCAN_SPAN);
                        return;
                    }
                }
                this.a.b("reconnStragety to the end");
                return;
            default:
                return;
        }
    }
}
