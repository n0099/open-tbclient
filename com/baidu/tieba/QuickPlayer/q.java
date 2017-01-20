package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Handler.Callback {
    final /* synthetic */ p aKO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.aKO = pVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        b bVar;
        b bVar2;
        b bVar3;
        if (message.what == 1) {
            if (message.obj instanceof e) {
                this.aKO.a((e) message.obj);
            }
        } else if (message.what == 2) {
            p pVar = this.aKO;
            bVar3 = this.aKO.aKF;
            pVar.a(bVar3);
            this.aKO.aKF = null;
        } else if (message.what == 3) {
            p pVar2 = this.aKO;
            bVar2 = this.aKO.aKF;
            pVar2.b(bVar2);
        } else if (message.what == 4) {
            p pVar3 = this.aKO;
            bVar = this.aKO.aKF;
            pVar3.c(bVar);
        } else if (message.what != 5) {
            if (message.what == 10) {
                if (message.obj instanceof e) {
                    this.aKO.a((e) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                this.aKO.Ja();
            }
        } else {
            this.aKO.fK(message.arg1);
        }
        return true;
    }
}
