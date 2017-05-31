package com.baidu.tbadk.k;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a aHO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aHO = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.aHM != null) {
            a.aHM.setLength(message.arg1);
            a.aHM.setSize(message.arg2);
            if (a.aHM.getCallback() != null) {
                a.aHM.getCallback().e(a.aHM);
            }
        }
    }
}
