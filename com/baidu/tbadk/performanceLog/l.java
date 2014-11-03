package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Handler {
    final /* synthetic */ k YW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(k kVar, Looper looper) {
        super(looper);
        this.YW = kVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        m mVar;
        m mVar2;
        this.YW.YU = new m(this.YW);
        mVar = this.YW.YU;
        mVar.setSelfExecute(true);
        mVar2 = this.YW.YU;
        mVar2.execute(new String[0]);
    }
}
