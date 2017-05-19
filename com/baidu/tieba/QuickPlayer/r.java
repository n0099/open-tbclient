package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Handler.Callback {
    final /* synthetic */ p aRk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.aRk = pVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        v.c cVar;
        v.c cVar2;
        v.b bVar;
        v.b bVar2;
        v.a aVar;
        v.a aVar2;
        v.d dVar;
        v.d dVar2;
        if (message.what == 6) {
            dVar = this.aRk.aRd;
            if (dVar != null) {
                dVar2 = this.aRk.aRd;
                dVar2.onPrepared(this.aRk);
            }
        } else if (message.what == 7) {
            aVar = this.aRk.aRc;
            if (aVar != null) {
                aVar2 = this.aRk.aRc;
                aVar2.onCompletion(this.aRk);
            }
        } else if (message.what == 8) {
            bVar = this.aRk.aRe;
            if (bVar != null) {
                bVar2 = this.aRk.aRe;
                if (bVar2.onError(this.aRk, message.arg1, message.arg2)) {
                }
            }
        } else if (message.what == 9) {
            cVar = this.aRk.aRf;
            if (cVar != null) {
                cVar2 = this.aRk.aRf;
                cVar2.a(this.aRk, message.arg1, message.arg2);
            }
        }
        return true;
    }
}
