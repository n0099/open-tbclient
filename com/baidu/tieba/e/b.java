package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.e.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a bCp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bCp = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a.InterfaceC0056a interfaceC0056a;
        a.InterfaceC0056a interfaceC0056a2;
        int i = message.arg1;
        int i2 = message.arg2;
        switch (message.what) {
            case 0:
                interfaceC0056a2 = this.bCp.aQW;
                interfaceC0056a2.V(i, i2);
                return true;
            case 1:
                interfaceC0056a = this.bCp.aQW;
                interfaceC0056a.W(i, i2);
                return true;
            default:
                return false;
        }
    }
}
