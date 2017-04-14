package com.baidu.tbadk.k;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a aHV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aHV = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.aHT != null) {
            a.aHT.setLength(message.arg1);
            a.aHT.setSize(message.arg2);
            if (a.aHT.getCallback() != null) {
                a.aHT.getCallback().e(a.aHT);
            }
        }
    }
}
