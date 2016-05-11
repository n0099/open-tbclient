package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tbadk.performanceLog.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends Handler {
    final /* synthetic */ p axp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, Looper looper) {
        super(looper);
        this.axp = pVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        p.a aVar;
        p.a aVar2;
        this.axp.axn = new p.a();
        aVar = this.axp.axn;
        aVar.setSelfExecute(true);
        aVar2 = this.axp.axn;
        aVar2.execute(new String[0]);
    }
}
