package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.e.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a bEz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bEz = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a.InterfaceC0055a interfaceC0055a;
        a.InterfaceC0055a interfaceC0055a2;
        int i = message.arg1;
        int i2 = message.arg2;
        switch (message.what) {
            case 0:
                interfaceC0055a2 = this.bEz.aRo;
                interfaceC0055a2.V(i, i2);
                return true;
            case 1:
                interfaceC0055a = this.bEz.aRo;
                interfaceC0055a.W(i, i2);
                return true;
            default:
                return false;
        }
    }
}
