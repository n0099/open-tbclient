package com.baidu.tieba.frs.f;

import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tieba.frs.entelechy.b.f {
    final /* synthetic */ ad cdk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.cdk = adVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void abi() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        this.cdk.abi();
        frsActivity = this.cdk.bTf;
        if (frsActivity.YE() != null) {
            frsActivity2 = this.cdk.bTf;
            frsActivity2.YE().dB(false);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void abj() {
        this.cdk.abj();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void abk() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        this.cdk.cdj = true;
        frsActivity = this.cdk.bTf;
        if (frsActivity.YE() != null) {
            frsActivity2 = this.cdk.bTf;
            frsActivity2.YE().dB(false);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void abl() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        this.cdk.cdj = false;
        frsActivity = this.cdk.bTf;
        if (frsActivity.YE() != null) {
            frsActivity2 = this.cdk.bTf;
            frsActivity2.YE().dB(true);
        }
    }
}
