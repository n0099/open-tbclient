package com.baidu.tieba.b.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.b.b.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Handler.Callback {
    final /* synthetic */ g brg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.brg = gVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        g.a aVar;
        g.a aVar2;
        g.a aVar3;
        g.a aVar4;
        switch (message.what) {
            case 1:
                aVar3 = this.brg.brf;
                if (aVar3 != null) {
                    aVar4 = this.brg.brf;
                    aVar4.cP(true);
                    return true;
                }
                return true;
            case 2:
                aVar = this.brg.brf;
                if (aVar != null) {
                    aVar2 = this.brg.brf;
                    aVar2.cP(false);
                    return true;
                }
                return true;
            default:
                return false;
        }
    }
}
