package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Handler.Callback {
    final /* synthetic */ p aRk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.aRk = pVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        b bVar;
        b bVar2;
        b bVar3;
        if (message.what == 1) {
            if (message.obj instanceof e) {
                this.aRk.a((e) message.obj);
            }
        } else if (message.what == 2) {
            p pVar = this.aRk;
            bVar3 = this.aRk.aRb;
            pVar.a(bVar3);
            this.aRk.aRb = null;
        } else if (message.what == 3) {
            p pVar2 = this.aRk;
            bVar2 = this.aRk.aRb;
            pVar2.b(bVar2);
        } else if (message.what == 4) {
            p pVar3 = this.aRk;
            bVar = this.aRk.aRb;
            pVar3.c(bVar);
        } else if (message.what != 5) {
            if (message.what == 10) {
                if (message.obj instanceof e) {
                    this.aRk.a((e) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                this.aRk.Jt();
            }
        } else {
            this.aRk.fE(message.arg1);
        }
        return true;
    }
}
