package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.e.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a bQS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bQS = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a.InterfaceC0062a interfaceC0062a;
        a.InterfaceC0062a interfaceC0062a2;
        int i = message.arg1;
        int i2 = message.arg2;
        switch (message.what) {
            case 0:
                interfaceC0062a2 = this.bQS.bQR;
                interfaceC0062a2.ah(i, i2);
                return true;
            case 1:
                interfaceC0062a = this.bQS.bQR;
                interfaceC0062a.ai(i, i2);
                return true;
            default:
                return false;
        }
    }
}
