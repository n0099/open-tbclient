package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements l {
    final /* synthetic */ q agw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.agw = qVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.l
    public void aJ(boolean z) {
        List list;
        f.xt().dd(z ? 2 : 1);
        if (z) {
            this.agw.afK = a.xl().xo();
            list = this.agw.afK;
            if (list != null) {
                this.agw.dV("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.xl().a(new u(this));
                return;
            }
        }
        this.agw.agu = false;
        this.agw.xF();
    }
}
