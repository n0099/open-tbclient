package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Handler.Callback {
    final /* synthetic */ j aLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aLC = jVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a aVar;
        a aVar2;
        a aVar3;
        if (message.what == 1) {
            if (message.obj instanceof c) {
                this.aLC.a((c) message.obj);
            }
        } else if (message.what == 2) {
            j jVar = this.aLC;
            aVar3 = this.aLC.aLp;
            jVar.a(aVar3);
            this.aLC.aLp = null;
        } else if (message.what == 3) {
            j jVar2 = this.aLC;
            aVar2 = this.aLC.aLp;
            jVar2.b(aVar2);
        } else if (message.what == 4) {
            j jVar3 = this.aLC;
            aVar = this.aLC.aLp;
            jVar3.c(aVar);
        } else if (message.what == 5) {
            this.aLC.fH(message.arg1);
        }
        return true;
    }
}
