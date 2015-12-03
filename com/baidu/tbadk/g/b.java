package com.baidu.tbadk.g;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a azC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.azC = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.azA != null) {
            a.azA.setLength(message.arg1);
            a.azA.setSize(message.arg2);
            if (a.azA.getCallback() != null) {
                a.azA.getCallback().e(a.azA);
            }
        }
    }
}
