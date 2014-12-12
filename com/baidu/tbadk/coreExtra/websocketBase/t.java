package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements l {
    final /* synthetic */ q VO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.VO = qVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.l
    public void aB(boolean z) {
        List list;
        f.tR().cU(z ? 2 : 1);
        if (z) {
            this.VO.Vc = a.tJ().tM();
            list = this.VO.Vc;
            if (list != null) {
                this.VO.dQ("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.tJ().a(new u(this));
                return;
            }
        }
        this.VO.VM = false;
        this.VO.ud();
    }
}
