package com.baidu.tieba.b.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.b.b.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Handler.Callback {
    final /* synthetic */ g bsK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bsK = gVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        g.a aVar;
        g.a aVar2;
        g.a aVar3;
        g.a aVar4;
        switch (message.what) {
            case 1:
                aVar3 = this.bsK.bsJ;
                if (aVar3 != null) {
                    aVar4 = this.bsK.bsJ;
                    aVar4.cX(true);
                    return true;
                }
                return true;
            case 2:
                aVar = this.bsK.bsJ;
                if (aVar != null) {
                    aVar2 = this.bsK.bsJ;
                    aVar2.cX(false);
                    return true;
                }
                return true;
            default:
                return false;
        }
    }
}
