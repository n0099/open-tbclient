package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i aoQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.aoQ = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void bp(boolean z) {
        List list;
        c.Af().dU(z ? 2 : 1);
        if (z) {
            this.aoQ.aoc = a.zX().Aa();
            list = this.aoQ.aoc;
            if (list != null) {
                this.aoQ.eW("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.zX().a(new m(this));
                return;
            }
        }
        this.aoQ.aoO = false;
        this.aoQ.As();
    }
}
