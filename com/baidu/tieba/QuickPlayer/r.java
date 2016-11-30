package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.play.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Handler.Callback {
    final /* synthetic */ p aMv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.aMv = pVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        t.c cVar;
        t.c cVar2;
        t.b bVar;
        t.b bVar2;
        t.a aVar;
        t.a aVar2;
        t.d dVar;
        t.d dVar2;
        if (message.what == 6) {
            dVar = this.aMv.aMo;
            if (dVar != null) {
                dVar2 = this.aMv.aMo;
                dVar2.onPrepared(this.aMv);
            }
        } else if (message.what == 7) {
            aVar = this.aMv.aMn;
            if (aVar != null) {
                aVar2 = this.aMv.aMn;
                aVar2.onCompletion(this.aMv);
            }
        } else if (message.what == 8) {
            bVar = this.aMv.aMp;
            if (bVar != null) {
                bVar2 = this.aMv.aMp;
                if (bVar2.onError(this.aMv, message.arg1, message.arg2)) {
                }
            }
        } else if (message.what == 9) {
            cVar = this.aMv.aMq;
            if (cVar != null) {
                cVar2 = this.aMv.aMq;
                cVar2.a(this.aMv, message.arg1, message.arg2);
            }
        }
        return true;
    }
}
