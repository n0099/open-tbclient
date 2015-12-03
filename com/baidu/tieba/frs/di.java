package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class di implements Handler.Callback {
    final /* synthetic */ dh bdU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(dh dhVar) {
        this.bdU = dhVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.bdU.ws();
                return false;
            default:
                return false;
        }
    }
}
