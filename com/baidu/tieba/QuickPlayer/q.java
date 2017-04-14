package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Handler.Callback {
    final /* synthetic */ p aQP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.aQP = pVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        b bVar;
        b bVar2;
        b bVar3;
        if (message.what == 1) {
            if (message.obj instanceof e) {
                this.aQP.a((e) message.obj);
            }
        } else if (message.what == 2) {
            p pVar = this.aQP;
            bVar3 = this.aQP.aQG;
            pVar.a(bVar3);
            this.aQP.aQG = null;
        } else if (message.what == 3) {
            p pVar2 = this.aQP;
            bVar2 = this.aQP.aQG;
            pVar2.b(bVar2);
        } else if (message.what == 4) {
            p pVar3 = this.aQP;
            bVar = this.aQP.aQG;
            pVar3.c(bVar);
        } else if (message.what != 5) {
            if (message.what == 10) {
                if (message.obj instanceof e) {
                    this.aQP.a((e) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                this.aQP.Kf();
            }
        } else {
            this.aQP.fH(message.arg1);
        }
        return true;
    }
}
