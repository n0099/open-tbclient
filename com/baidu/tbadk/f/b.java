package com.baidu.tbadk.f;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a ayI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ayI = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.ayG != null) {
            a.ayG.setLength(message.arg1);
            a.ayG.setSize(message.arg2);
            if (a.ayG.getCallback() != null) {
                a.ayG.getCallback().e(a.ayG);
            }
        }
    }
}
