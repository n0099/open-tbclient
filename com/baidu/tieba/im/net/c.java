package com.baidu.tieba.im.net;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.util.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f1856a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f1856a = bVar;
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
                handler = this.f1856a.d;
                handler.removeMessages(1);
                StringBuilder append = new StringBuilder().append("this is reconn time:");
                i = this.f1856a.b;
                bd.b(append.append(i).toString());
                TiebaSocketLinkService.a(true, "time to reconnStragety");
                b.c(this.f1856a);
                iArr = this.f1856a.c;
                if (iArr != null) {
                    i2 = this.f1856a.b;
                    iArr2 = this.f1856a.c;
                    if (i2 < iArr2.length) {
                        StringBuilder append2 = new StringBuilder().append("Next will be delay:");
                        iArr3 = this.f1856a.c;
                        i3 = this.f1856a.b;
                        bd.b(append2.append(iArr3[i3]).toString());
                        handler2 = this.f1856a.d;
                        handler3 = this.f1856a.d;
                        Message obtainMessage = handler3.obtainMessage(1);
                        iArr4 = this.f1856a.c;
                        i4 = this.f1856a.b;
                        handler2.sendMessageDelayed(obtainMessage, iArr4[i4] * LocationClientOption.MIN_SCAN_SPAN);
                        return;
                    }
                }
                this.f1856a.b("reconnStragety to the end");
                return;
            default:
                return;
        }
    }
}
