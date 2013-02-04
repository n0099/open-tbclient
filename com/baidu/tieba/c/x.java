package com.baidu.tieba.c;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            w wVar = (w) message.obj;
            if (wVar != null) {
                wVar.i();
            }
        } catch (Exception e) {
            ae.b(getClass().getName(), "initNetWorkCore", e.getMessage());
        }
    }
}
