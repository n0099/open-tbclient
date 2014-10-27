package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Handler {
    final /* synthetic */ k YS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(k kVar, Looper looper) {
        super(looper);
        this.YS = kVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        m mVar;
        m mVar2;
        this.YS.YQ = new m(this.YS);
        mVar = this.YS.YQ;
        mVar.setSelfExecute(true);
        mVar2 = this.YS.YQ;
        mVar2.execute(new String[0]);
    }
}
