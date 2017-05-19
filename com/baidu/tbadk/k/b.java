package com.baidu.tbadk.k;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a aIb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aIb = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.aHZ != null) {
            a.aHZ.setLength(message.arg1);
            a.aHZ.setSize(message.arg2);
            if (a.aHZ.getCallback() != null) {
                a.aHZ.getCallback().e(a.aHZ);
            }
        }
    }
}
