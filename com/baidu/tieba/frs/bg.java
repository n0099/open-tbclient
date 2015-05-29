package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements com.baidu.tbadk.coreExtra.view.b {
    final /* synthetic */ bf aOm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bf bfVar) {
        this.aOm = bfVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void xJ() {
        com.baidu.tbadk.core.data.k kVar;
        com.baidu.tbadk.core.data.k kVar2;
        kVar = this.aOm.aNZ;
        if (kVar != null) {
            kVar2 = this.aOm.aNZ;
            if (kVar2.getType() == 2) {
                this.aOm.Lb();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void xK() {
        this.aOm.Lr();
    }
}
