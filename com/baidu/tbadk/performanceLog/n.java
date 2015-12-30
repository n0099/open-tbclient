package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tbadk.performanceLog.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends Handler {
    final /* synthetic */ m azG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(m mVar, Looper looper) {
        super(looper);
        this.azG = mVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        m.a aVar;
        m.a aVar2;
        this.azG.azE = new m.a();
        aVar = this.azG.azE;
        aVar.setSelfExecute(true);
        aVar2 = this.azG.azE;
        aVar2.execute(new String[0]);
    }
}
