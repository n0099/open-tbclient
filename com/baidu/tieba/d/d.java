package com.baidu.tieba.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.d.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Handler.Callback {
    final /* synthetic */ c aYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aYD = cVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        c.InterfaceC0054c interfaceC0054c;
        c.InterfaceC0054c interfaceC0054c2;
        int i = message.arg1;
        int i2 = message.arg2;
        switch (message.what) {
            case 0:
                interfaceC0054c2 = this.aYD.aYC;
                interfaceC0054c2.K(i, i2);
                return true;
            case 1:
                interfaceC0054c = this.aYD.aYC;
                interfaceC0054c.L(i, i2);
                return true;
            default:
                return false;
        }
    }
}
