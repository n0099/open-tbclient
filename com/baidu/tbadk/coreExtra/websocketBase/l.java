package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i aqx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.aqx = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void ba(boolean z) {
        List list;
        c.Am().dP(z ? 2 : 1);
        if (z) {
            this.aqx.apK = a.Ae().Ah();
            list = this.aqx.apK;
            if (list != null) {
                this.aqx.eR("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.Ae().a(new m(this));
                return;
            }
        }
        this.aqx.aqv = false;
        this.aqx.Az();
    }
}
