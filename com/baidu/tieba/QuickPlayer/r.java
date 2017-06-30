package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Handler.Callback {
    final /* synthetic */ p aSE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.aSE = pVar;
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
            dVar = this.aSE.aSx;
            if (dVar != null) {
                dVar2 = this.aSE.aSx;
                dVar2.onPrepared(this.aSE);
            }
        } else if (message.what == 7) {
            aVar = this.aSE.aSw;
            if (aVar != null) {
                aVar2 = this.aSE.aSw;
                aVar2.onCompletion(this.aSE);
            }
        } else if (message.what == 8) {
            bVar = this.aSE.aSy;
            if (bVar != null) {
                bVar2 = this.aSE.aSy;
                if (bVar2.onError(this.aSE, message.arg1, message.arg2)) {
                }
            }
        } else if (message.what == 9) {
            cVar = this.aSE.aSz;
            if (cVar != null) {
                cVar2 = this.aSE.aSz;
                cVar2.a(this.aSE, message.arg1, message.arg2);
            }
        }
        return true;
    }
}
