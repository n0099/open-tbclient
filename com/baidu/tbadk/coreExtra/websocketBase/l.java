package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i arH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.arH = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void bi(boolean z) {
        List list;
        c.Cf().en(z ? 2 : 1);
        if (z) {
            this.arH.aqT = a.BX().Ca();
            list = this.arH.aqT;
            if (list != null) {
                this.arH.eX("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.BX().a(new m(this));
                return;
            }
        }
        this.arH.arF = false;
        this.arH.Cs();
    }
}
