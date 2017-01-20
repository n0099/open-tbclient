package com.baidu.tieba.card;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends Handler {
    final /* synthetic */ x bml;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(x xVar, Looper looper) {
        super(looper);
        this.bml = xVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 202:
                this.bml.Ke();
                return;
            case 203:
                this.bml.Kf();
                return;
            default:
                return;
        }
    }
}
