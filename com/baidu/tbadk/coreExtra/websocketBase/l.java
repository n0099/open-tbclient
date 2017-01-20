package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i ark;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.ark = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void bu(boolean z) {
        List list;
        c.Bn().em(z ? 2 : 1);
        if (z) {
            this.ark.aqx = a.Bf().Bi();
            list = this.ark.aqx;
            if (list != null) {
                this.ark.eX("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.Bf().a(new m(this));
                return;
            }
        }
        this.ark.ari = false;
        this.ark.BA();
    }
}
