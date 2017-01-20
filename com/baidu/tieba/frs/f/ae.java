package com.baidu.tieba.frs.f;

import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tieba.frs.entelechy.b.f {
    final /* synthetic */ ad bVS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.bVS = adVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void aal() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        this.bVS.aal();
        frsActivity = this.bVS.bLZ;
        if (frsActivity.XF() != null) {
            frsActivity2 = this.bVS.bLZ;
            frsActivity2.XF().dB(false);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void aam() {
        this.bVS.aam();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void aan() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        this.bVS.bVR = true;
        frsActivity = this.bVS.bLZ;
        if (frsActivity.XF() != null) {
            frsActivity2 = this.bVS.bLZ;
            frsActivity2.XF().dB(false);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void aao() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        this.bVS.bVR = false;
        frsActivity = this.bVS.bLZ;
        if (frsActivity.XF() != null) {
            frsActivity2 = this.bVS.bLZ;
            frsActivity2.XF().dB(true);
        }
    }
}
