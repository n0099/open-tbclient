package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements com.baidu.tbadk.coreExtra.view.b {
    final /* synthetic */ bf aOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bf bfVar) {
        this.aOn = bfVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void xK() {
        com.baidu.tbadk.core.data.k kVar;
        com.baidu.tbadk.core.data.k kVar2;
        kVar = this.aOn.aOa;
        if (kVar != null) {
            kVar2 = this.aOn.aOa;
            if (kVar2.getType() == 2) {
                this.aOn.Lc();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void xL() {
        this.aOn.Ls();
    }
}
