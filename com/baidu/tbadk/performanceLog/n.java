package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tbadk.performanceLog.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends Handler {
    final /* synthetic */ m axj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(m mVar, Looper looper) {
        super(looper);
        this.axj = mVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        m.a aVar;
        m.a aVar2;
        this.axj.axh = new m.a();
        aVar = this.axj.axh;
        aVar.setSelfExecute(true);
        aVar2 = this.axj.axh;
        aVar2.execute(new String[0]);
    }
}
