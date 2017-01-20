package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.f.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a bvj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bvj = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a.InterfaceC0057a interfaceC0057a;
        a.InterfaceC0057a interfaceC0057a2;
        int i = message.arg1;
        int i2 = message.arg2;
        switch (message.what) {
            case 0:
                interfaceC0057a2 = this.bvj.aLl;
                interfaceC0057a2.Q(i, i2);
                return true;
            case 1:
                interfaceC0057a = this.bvj.aLl;
                interfaceC0057a.R(i, i2);
                return true;
            default:
                return false;
        }
    }
}
