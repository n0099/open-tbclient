package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends Handler {
    final /* synthetic */ r apb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, Looper looper) {
        super(looper);
        this.apb = rVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        t tVar;
        t tVar2;
        this.apb.aoZ = new t(this.apb);
        tVar = this.apb.aoZ;
        tVar.setSelfExecute(true);
        tVar2 = this.apb.aoZ;
        tVar2.execute(new String[0]);
    }
}
