package com.baidu.tbadk.g;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a aHG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aHG = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.aHE != null) {
            a.aHE.setLength(message.arg1);
            a.aHE.setSize(message.arg2);
            if (a.aHE.getCallback() != null) {
                a.aHE.getCallback().e(a.aHE);
            }
        }
    }
}
