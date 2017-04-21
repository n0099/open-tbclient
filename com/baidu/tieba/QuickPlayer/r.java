package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Handler.Callback {
    final /* synthetic */ p aQR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.aQR = pVar;
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
            dVar = this.aQR.aQK;
            if (dVar != null) {
                dVar2 = this.aQR.aQK;
                dVar2.onPrepared(this.aQR);
            }
        } else if (message.what == 7) {
            aVar = this.aQR.aQJ;
            if (aVar != null) {
                aVar2 = this.aQR.aQJ;
                aVar2.onCompletion(this.aQR);
            }
        } else if (message.what == 8) {
            bVar = this.aQR.aQL;
            if (bVar != null) {
                bVar2 = this.aQR.aQL;
                if (bVar2.onError(this.aQR, message.arg1, message.arg2)) {
                }
            }
        } else if (message.what == 9) {
            cVar = this.aQR.aQM;
            if (cVar != null) {
                cVar2 = this.aQR.aQM;
                cVar2.a(this.aQR, message.arg1, message.arg2);
            }
        }
        return true;
    }
}
