package com.baidu.tieba.a.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.a.b.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Handler.Callback {
    final /* synthetic */ g aMD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aMD = gVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        g.a aVar;
        g.a aVar2;
        g.a aVar3;
        g.a aVar4;
        switch (message.what) {
            case 1:
                aVar3 = this.aMD.aMC;
                if (aVar3 != null) {
                    aVar4 = this.aMD.aMC;
                    aVar4.cc(true);
                    return true;
                }
                return true;
            case 2:
                aVar = this.aMD.aMC;
                if (aVar != null) {
                    aVar2 = this.aMD.aMC;
                    aVar2.cc(false);
                    return true;
                }
                return true;
            default:
                return false;
        }
    }
}
