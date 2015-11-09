package com.baidu.tieba.account;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class a extends Handler {
    final /* synthetic */ AccountActivity aDq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AccountActivity accountActivity) {
        this.aDq = accountActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                this.aDq.FM();
                return;
            case 2:
                if (message.obj instanceof AccountData) {
                    this.aDq.k((AccountData) message.obj);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
