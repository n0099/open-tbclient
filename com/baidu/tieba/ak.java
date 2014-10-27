package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Handler.Callback {
    final /* synthetic */ aj adY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.adY = ajVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 2:
            case 3:
            default:
                return false;
        }
    }
}
