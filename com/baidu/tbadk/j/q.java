package com.baidu.tbadk.j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tbadk.j.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends Handler {
    final /* synthetic */ p aHx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, Looper looper) {
        super(looper);
        this.aHx = pVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        p.a aVar;
        p.a aVar2;
        this.aHx.aHv = new p.a();
        aVar = this.aHx.aHv;
        aVar.setSelfExecute(true);
        aVar2 = this.aHx.aHv;
        aVar2.execute(new String[0]);
    }
}
