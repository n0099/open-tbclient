package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Handler.Callback {
    final /* synthetic */ p aLM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.aLM = pVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        b bVar;
        b bVar2;
        b bVar3;
        if (message.what == 1) {
            if (message.obj instanceof e) {
                this.aLM.a((e) message.obj);
            }
        } else if (message.what == 2) {
            p pVar = this.aLM;
            bVar3 = this.aLM.aLD;
            pVar.a(bVar3);
            this.aLM.aLD = null;
        } else if (message.what == 3) {
            p pVar2 = this.aLM;
            bVar2 = this.aLM.aLD;
            pVar2.b(bVar2);
        } else if (message.what == 4) {
            p pVar3 = this.aLM;
            bVar = this.aLM.aLD;
            pVar3.c(bVar);
        } else if (message.what == 5) {
            this.aLM.fG(message.arg1);
        }
        return true;
    }
}
