package com.baidu.tbadk.k;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a aJc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aJc = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.aJa != null) {
            a.aJa.setLength(message.arg1);
            a.aJa.setSize(message.arg2);
            if (a.aJa.getCallback() != null) {
                a.aJa.getCallback().e(a.aJa);
            }
        }
    }
}
