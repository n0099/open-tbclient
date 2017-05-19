package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.e.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a bEG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bEG = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a.InterfaceC0059a interfaceC0059a;
        a.InterfaceC0059a interfaceC0059a2;
        int i = message.arg1;
        int i2 = message.arg2;
        switch (message.what) {
            case 0:
                interfaceC0059a2 = this.bEG.aRJ;
                interfaceC0059a2.W(i, i2);
                return true;
            case 1:
                interfaceC0059a = this.bEG.aRJ;
                interfaceC0059a.X(i, i2);
                return true;
            default:
                return false;
        }
    }
}
