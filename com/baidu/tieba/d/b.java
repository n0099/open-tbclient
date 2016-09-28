package com.baidu.tieba.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a blh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.blh = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a.InterfaceC0058a interfaceC0058a;
        a.InterfaceC0058a interfaceC0058a2;
        int i = message.arg1;
        int i2 = message.arg2;
        switch (message.what) {
            case 0:
                interfaceC0058a2 = this.blh.aMy;
                interfaceC0058a2.O(i, i2);
                return true;
            case 1:
                interfaceC0058a = this.blh.aMy;
                interfaceC0058a.P(i, i2);
                return true;
            default:
                return false;
        }
    }
}
