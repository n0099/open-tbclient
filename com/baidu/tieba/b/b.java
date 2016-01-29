package com.baidu.tieba.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aUy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aUy = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a.InterfaceC0059a interfaceC0059a;
        a.InterfaceC0059a interfaceC0059a2;
        int i = message.arg1;
        int i2 = message.arg2;
        switch (message.what) {
            case 0:
                interfaceC0059a2 = this.aUy.aUx;
                interfaceC0059a2.P(i, i2);
                return true;
            case 1:
                interfaceC0059a = this.aUy.aUx;
                interfaceC0059a.Q(i, i2);
                return true;
            default:
                return false;
        }
    }
}
