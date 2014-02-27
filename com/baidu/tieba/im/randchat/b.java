package com.baidu.tieba.im.randchat;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends Handler {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i;
        int i2;
        String[] strArr;
        Handler handler;
        Handler handler2;
        Handler handler3;
        c cVar;
        c cVar2;
        int i3;
        int i4;
        Handler handler4;
        Handler handler5;
        switch (message.what) {
            case 0:
                a aVar = this.a;
                i3 = aVar.s;
                aVar.s = i3 + 1;
                i4 = this.a.s;
                if (i4 == 3) {
                    this.a.s = 0;
                }
                this.a.invalidate();
                handler4 = this.a.v;
                handler4.removeMessages(0);
                handler5 = this.a.v;
                handler5.sendEmptyMessageDelayed(0, 800L);
                return;
            case 1:
                a aVar2 = this.a;
                i = aVar2.t;
                aVar2.t = i + 1;
                i2 = this.a.t;
                strArr = this.a.o;
                if (i2 == strArr.length) {
                    handler3 = this.a.v;
                    handler3.removeMessages(1);
                    cVar = this.a.u;
                    if (cVar != null) {
                        cVar2 = this.a.u;
                        cVar2.a();
                        return;
                    }
                    return;
                }
                this.a.invalidate();
                handler = this.a.v;
                handler.removeMessages(1);
                handler2 = this.a.v;
                handler2.sendEmptyMessageDelayed(1, 1000L);
                return;
            default:
                return;
        }
    }
}
