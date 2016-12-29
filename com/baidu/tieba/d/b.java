package com.baidu.tieba.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a bnw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bnw = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a.InterfaceC0057a interfaceC0057a;
        a.InterfaceC0057a interfaceC0057a2;
        int i = message.arg1;
        int i2 = message.arg2;
        switch (message.what) {
            case 0:
                interfaceC0057a2 = this.bnw.aMk;
                interfaceC0057a2.P(i, i2);
                return true;
            case 1:
                interfaceC0057a = this.bnw.aMk;
                interfaceC0057a.Q(i, i2);
                return true;
            default:
                return false;
        }
    }
}
