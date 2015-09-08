package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tbadk.performanceLog.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends Handler {
    final /* synthetic */ m ayJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(m mVar, Looper looper) {
        super(looper);
        this.ayJ = mVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        m.a aVar;
        m.a aVar2;
        this.ayJ.ayH = new m.a();
        aVar = this.ayJ.ayH;
        aVar.setSelfExecute(true);
        aVar2 = this.ayJ.ayH;
        aVar2.execute(new String[0]);
    }
}
