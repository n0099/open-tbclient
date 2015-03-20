package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements com.baidu.tbadk.coreExtra.view.b {
    final /* synthetic */ bf aLR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bf bfVar) {
        this.aLR = bfVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void wR() {
        com.baidu.tbadk.core.data.k kVar;
        com.baidu.tbadk.core.data.k kVar2;
        kVar = this.aLR.aLF;
        if (kVar != null) {
            kVar2 = this.aLR.aLF;
            if (kVar2.getType() == 2) {
                this.aLR.JP();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void wS() {
        this.aLR.Kf();
    }
}
