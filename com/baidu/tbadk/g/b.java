package com.baidu.tbadk.g;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a aCS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aCS = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.aCQ != null) {
            a.aCQ.setLength(message.arg1);
            a.aCQ.setSize(message.arg2);
            if (a.aCQ.getCallback() != null) {
                a.aCQ.getCallback().e(a.aCQ);
            }
        }
    }
}
