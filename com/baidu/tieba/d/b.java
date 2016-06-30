package com.baidu.tieba.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aYz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aYz = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a.InterfaceC0053a interfaceC0053a;
        a.InterfaceC0053a interfaceC0053a2;
        int i = message.arg1;
        int i2 = message.arg2;
        switch (message.what) {
            case 0:
                interfaceC0053a2 = this.aYz.aKA;
                interfaceC0053a2.K(i, i2);
                return true;
            case 1:
                interfaceC0053a = this.aYz.aKA;
                interfaceC0053a.L(i, i2);
                return true;
            default:
                return false;
        }
    }
}
