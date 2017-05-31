package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Handler.Callback {
    final /* synthetic */ p aRl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.aRl = pVar;
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
            dVar = this.aRl.aRe;
            if (dVar != null) {
                dVar2 = this.aRl.aRe;
                dVar2.onPrepared(this.aRl);
            }
        } else if (message.what == 7) {
            aVar = this.aRl.aRd;
            if (aVar != null) {
                aVar2 = this.aRl.aRd;
                aVar2.onCompletion(this.aRl);
            }
        } else if (message.what == 8) {
            bVar = this.aRl.aRf;
            if (bVar != null) {
                bVar2 = this.aRl.aRf;
                if (bVar2.onError(this.aRl, message.arg1, message.arg2)) {
                }
            }
        } else if (message.what == 9) {
            cVar = this.aRl.aRg;
            if (cVar != null) {
                cVar2 = this.aRl.aRg;
                cVar2.a(this.aRl, message.arg1, message.arg2);
            }
        }
        return true;
    }
}
