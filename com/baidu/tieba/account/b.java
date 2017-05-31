package com.baidu.tieba.account;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class b extends Handler {
    final /* synthetic */ AccountActivity aTw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AccountActivity accountActivity) {
        this.aTw = accountActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                this.aTw.Kg();
                return;
            case 2:
                if (message.obj instanceof AccountData) {
                    this.aTw.m((AccountData) message.obj);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
