package com.baidu.tieba.b.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.b.b.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Handler.Callback {
    final /* synthetic */ g aPW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aPW = gVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        g.a aVar;
        g.a aVar2;
        g.a aVar3;
        g.a aVar4;
        switch (message.what) {
            case 1:
                aVar3 = this.aPW.aPV;
                if (aVar3 != null) {
                    aVar4 = this.aPW.aPV;
                    aVar4.cf(true);
                    return true;
                }
                return true;
            case 2:
                aVar = this.aPW.aPV;
                if (aVar != null) {
                    aVar2 = this.aPW.aPV;
                    aVar2.cf(false);
                    return true;
                }
                return true;
            default:
                return false;
        }
    }
}
