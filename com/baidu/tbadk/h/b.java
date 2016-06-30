package com.baidu.tbadk.h;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a azL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.azL = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.azJ != null) {
            a.azJ.setLength(message.arg1);
            a.azJ.setSize(message.arg2);
            if (a.azJ.getCallback() != null) {
                a.azJ.getCallback().e(a.azJ);
            }
        }
    }
}
