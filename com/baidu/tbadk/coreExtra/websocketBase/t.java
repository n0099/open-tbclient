package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements l {
    final /* synthetic */ q agE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.agE = qVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.l
    public void aJ(boolean z) {
        List list;
        f.xz().dd(z ? 2 : 1);
        if (z) {
            this.agE.afS = a.xr().xu();
            list = this.agE.afS;
            if (list != null) {
                this.agE.dY("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.xr().a(new u(this));
                return;
            }
        }
        this.agE.agC = false;
        this.agE.xL();
    }
}
