package com.baidu.tieba.b.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.b.b.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Handler.Callback {
    final /* synthetic */ g boP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.boP = gVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        g.a aVar;
        g.a aVar2;
        g.a aVar3;
        g.a aVar4;
        switch (message.what) {
            case 1:
                aVar3 = this.boP.boO;
                if (aVar3 != null) {
                    aVar4 = this.boP.boO;
                    aVar4.cF(true);
                    return true;
                }
                return true;
            case 2:
                aVar = this.boP.boO;
                if (aVar != null) {
                    aVar2 = this.boP.boO;
                    aVar2.cF(false);
                    return true;
                }
                return true;
            default:
                return false;
        }
    }
}
