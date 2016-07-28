package com.baidu.tieba.b.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.b.b.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Handler.Callback {
    final /* synthetic */ g aQQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aQQ = gVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        g.a aVar;
        g.a aVar2;
        g.a aVar3;
        g.a aVar4;
        switch (message.what) {
            case 1:
                aVar3 = this.aQQ.aQP;
                if (aVar3 != null) {
                    aVar4 = this.aQQ.aQP;
                    aVar4.ch(true);
                    return true;
                }
                return true;
            case 2:
                aVar = this.aQQ.aQP;
                if (aVar != null) {
                    aVar2 = this.aQQ.aQP;
                    aVar2.ch(false);
                    return true;
                }
                return true;
            default:
                return false;
        }
    }
}
