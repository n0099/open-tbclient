package com.baidu.tieba.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aZx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aZx = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a.InterfaceC0054a interfaceC0054a;
        a.InterfaceC0054a interfaceC0054a2;
        int i = message.arg1;
        int i2 = message.arg2;
        switch (message.what) {
            case 0:
                interfaceC0054a2 = this.aZx.aLt;
                interfaceC0054a2.K(i, i2);
                return true;
            case 1:
                interfaceC0054a = this.aZx.aLt;
                interfaceC0054a.L(i, i2);
                return true;
            default:
                return false;
        }
    }
}
