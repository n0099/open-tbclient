package com.baidu.tieba.c;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aVf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aVf = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a.InterfaceC0052a interfaceC0052a;
        a.InterfaceC0052a interfaceC0052a2;
        int i = message.arg1;
        int i2 = message.arg2;
        switch (message.what) {
            case 0:
                interfaceC0052a2 = this.aVf.aVe;
                interfaceC0052a2.O(i, i2);
                return true;
            case 1:
                interfaceC0052a = this.aVf.aVe;
                interfaceC0052a.P(i, i2);
                return true;
            default:
                return false;
        }
    }
}
