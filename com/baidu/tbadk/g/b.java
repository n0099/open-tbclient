package com.baidu.tbadk.g;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a aDl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aDl = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.aDj != null) {
            a.aDj.setLength(message.arg1);
            a.aDj.setSize(message.arg2);
            if (a.aDj.getCallback() != null) {
                a.aDj.getCallback().e(a.aDj);
            }
        }
    }
}
