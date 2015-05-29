package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements l {
    final /* synthetic */ q ahF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.ahF = qVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.l
    public void aQ(boolean z) {
        List list;
        f.ym().dm(z ? 2 : 1);
        if (z) {
            this.ahF.agT = a.ye().yh();
            list = this.ahF.agT;
            if (list != null) {
                this.ahF.ep("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.ye().a(new u(this));
                return;
            }
        }
        this.ahF.ahD = false;
        this.ahF.yy();
    }
}
