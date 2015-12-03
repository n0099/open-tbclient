package com.baidu.tieba.account;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class a extends Handler {
    final /* synthetic */ AccountActivity aGn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AccountActivity accountActivity) {
        this.aGn = accountActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                this.aGn.GT();
                return;
            case 2:
                if (message.obj instanceof AccountData) {
                    this.aGn.k((AccountData) message.obj);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
