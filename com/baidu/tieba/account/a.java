package com.baidu.tieba.account;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class a extends Handler {
    final /* synthetic */ AccountActivity aDy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AccountActivity accountActivity) {
        this.aDy = accountActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                this.aDy.FP();
                return;
            case 2:
                if (message.obj instanceof AccountData) {
                    this.aDy.n((AccountData) message.obj);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
