package com.baidu.tieba.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.d.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Handler.Callback {
    final /* synthetic */ c aZB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aZB = cVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        c.InterfaceC0055c interfaceC0055c;
        c.InterfaceC0055c interfaceC0055c2;
        int i = message.arg1;
        int i2 = message.arg2;
        switch (message.what) {
            case 0:
                interfaceC0055c2 = this.aZB.aZA;
                interfaceC0055c2.K(i, i2);
                return true;
            case 1:
                interfaceC0055c = this.aZB.aZA;
                interfaceC0055c.L(i, i2);
                return true;
            default:
                return false;
        }
    }
}
