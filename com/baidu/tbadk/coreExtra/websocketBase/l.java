package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i axP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.axP = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void bt(boolean z) {
        List list;
        c.BD().el(z ? 2 : 1);
        if (z) {
            this.axP.axb = a.Bv().By();
            list = this.axP.axb;
            if (list != null) {
                this.axP.fj("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.Bv().a(new m(this));
                return;
            }
        }
        this.axP.axN = false;
        this.axP.BQ();
    }
}
