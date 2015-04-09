package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements com.baidu.tbadk.coreExtra.view.b {
    final /* synthetic */ bf aMc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bf bfVar) {
        this.aMc = bfVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void wX() {
        com.baidu.tbadk.core.data.k kVar;
        com.baidu.tbadk.core.data.k kVar2;
        kVar = this.aMc.aLP;
        if (kVar != null) {
            kVar2 = this.aMc.aLP;
            if (kVar2.getType() == 2) {
                this.aMc.JW();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void wY() {
        this.aMc.Km();
    }
}
