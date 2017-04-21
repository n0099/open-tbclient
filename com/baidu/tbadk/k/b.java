package com.baidu.tbadk.k;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a aHX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aHX = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.aHV != null) {
            a.aHV.setLength(message.arg1);
            a.aHV.setSize(message.arg2);
            if (a.aHV.getCallback() != null) {
                a.aHV.getCallback().e(a.aHV);
            }
        }
    }
}
