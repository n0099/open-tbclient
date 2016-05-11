package com.baidu.tieba.c;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Handler.Callback {
    final /* synthetic */ c aVj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aVj = cVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        c.InterfaceC0053c interfaceC0053c;
        c.InterfaceC0053c interfaceC0053c2;
        int i = message.arg1;
        int i2 = message.arg2;
        switch (message.what) {
            case 0:
                interfaceC0053c2 = this.aVj.aVi;
                interfaceC0053c2.O(i, i2);
                return true;
            case 1:
                interfaceC0053c = this.aVj.aVi;
                interfaceC0053c.P(i, i2);
                return true;
            default:
                return false;
        }
    }
}
