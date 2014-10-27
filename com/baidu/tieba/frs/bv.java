package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements com.baidu.tbadk.coreExtra.view.b {
    final /* synthetic */ bu aDt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bu buVar) {
        this.aDt = buVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void pT() {
        com.baidu.tbadk.core.data.g gVar;
        com.baidu.tbadk.core.data.g gVar2;
        gVar = this.aDt.aDe;
        if (gVar != null) {
            gVar2 = this.aDt.aDe;
            if (gVar2.getType() == 2) {
                this.aDt.FV();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void pU() {
        this.aDt.GC();
    }
}
