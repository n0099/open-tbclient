package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Handler.Callback {
    final /* synthetic */ p aQz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.aQz = pVar;
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
            dVar = this.aQz.aQs;
            if (dVar != null) {
                dVar2 = this.aQz.aQs;
                dVar2.onPrepared(this.aQz);
            }
        } else if (message.what == 7) {
            aVar = this.aQz.aQr;
            if (aVar != null) {
                aVar2 = this.aQz.aQr;
                aVar2.onCompletion(this.aQz);
            }
        } else if (message.what == 8) {
            bVar = this.aQz.aQt;
            if (bVar != null) {
                bVar2 = this.aQz.aQt;
                if (bVar2.onError(this.aQz, message.arg1, message.arg2)) {
                }
            }
        } else if (message.what == 9) {
            cVar = this.aQz.aQu;
            if (cVar != null) {
                cVar2 = this.aQz.aQu;
                cVar2.a(this.aQz, message.arg1, message.arg2);
            }
        }
        return true;
    }
}
