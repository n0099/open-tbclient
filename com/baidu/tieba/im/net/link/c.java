package com.baidu.tieba.im.net.link;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f1759a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f1759a = bVar;
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
                handler = this.f1759a.d;
                handler.removeMessages(1);
                StringBuilder append = new StringBuilder().append("this is reconn time:");
                i = this.f1759a.b;
                bg.b(append.append(i).toString());
                TiebaSocketLinkService.a(true, "time to reconnStragety");
                b.c(this.f1759a);
                iArr = this.f1759a.c;
                if (iArr != null) {
                    i2 = this.f1759a.b;
                    iArr2 = this.f1759a.c;
                    if (i2 < iArr2.length) {
                        StringBuilder append2 = new StringBuilder().append("Next will be delay:");
                        iArr3 = this.f1759a.c;
                        i3 = this.f1759a.b;
                        bg.b(append2.append(iArr3[i3]).toString());
                        handler2 = this.f1759a.d;
                        handler3 = this.f1759a.d;
                        Message obtainMessage = handler3.obtainMessage(1);
                        iArr4 = this.f1759a.c;
                        i4 = this.f1759a.b;
                        handler2.sendMessageDelayed(obtainMessage, iArr4[i4] * LocationClientOption.MIN_SCAN_SPAN);
                        return;
                    }
                }
                this.f1759a.b("reconnStragety to the end");
                return;
            default:
                return;
        }
    }
}
