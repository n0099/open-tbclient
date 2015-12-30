package com.baidu.tbadk.g;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a aBf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aBf = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.aBd != null) {
            a.aBd.setLength(message.arg1);
            a.aBd.setSize(message.arg2);
            if (a.aBd.getCallback() != null) {
                a.aBd.getCallback().e(a.aBd);
            }
        }
    }
}
