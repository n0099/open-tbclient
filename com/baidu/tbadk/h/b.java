package com.baidu.tbadk.h;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a aDI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aDI = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.aDG != null) {
            a.aDG.setLength(message.arg1);
            a.aDG.setSize(message.arg2);
            if (a.aDG.getCallback() != null) {
                a.aDG.getCallback().e(a.aDG);
            }
        }
    }
}
