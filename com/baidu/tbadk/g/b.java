package com.baidu.tbadk.g;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a aBU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aBU = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.aBS != null) {
            a.aBS.setLength(message.arg1);
            a.aBS.setSize(message.arg2);
            if (a.aBS.getCallback() != null) {
                a.aBS.getCallback().e(a.aBS);
            }
        }
    }
}
