package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements Handler.Callback {
    final /* synthetic */ ch aYg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ch chVar) {
        this.aYg = chVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.aYg.Mo();
                return false;
            default:
                return false;
        }
    }
}
