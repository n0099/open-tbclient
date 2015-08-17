package com.baidu.tbadk.d;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a ayp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ayp = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.ayn != null) {
            a.ayn.setLength(message.arg1);
            a.ayn.setSize(message.arg2);
            if (a.ayn.getCallback() != null) {
                a.ayn.getCallback().e(a.ayn);
            }
        }
    }
}
