package com.baidu.tbadk.j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tbadk.j.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends Handler {
    final /* synthetic */ p aGw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, Looper looper) {
        super(looper);
        this.aGw = pVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        p.a aVar;
        p.a aVar2;
        this.aGw.aGu = new p.a();
        aVar = this.aGw.aGu;
        aVar.setSelfExecute(true);
        aVar2 = this.aGw.aGu;
        aVar2.execute(new String[0]);
    }
}
