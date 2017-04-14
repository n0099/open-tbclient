package com.baidu.tbadk.j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tbadk.j.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends Handler {
    final /* synthetic */ p aGq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, Looper looper) {
        super(looper);
        this.aGq = pVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        p.a aVar;
        p.a aVar2;
        this.aGq.aGo = new p.a();
        aVar = this.aGq.aGo;
        aVar.setSelfExecute(true);
        aVar2 = this.aGq.aGo;
        aVar2.execute(new String[0]);
    }
}
