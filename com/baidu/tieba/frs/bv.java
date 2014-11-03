package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements com.baidu.tbadk.coreExtra.view.b {
    final /* synthetic */ bu aDD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bu buVar) {
        this.aDD = buVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void pV() {
        com.baidu.tbadk.core.data.g gVar;
        com.baidu.tbadk.core.data.g gVar2;
        gVar = this.aDD.aDo;
        if (gVar != null) {
            gVar2 = this.aDD.aDo;
            if (gVar2.getType() == 2) {
                this.aDD.FX();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void pW() {
        this.aDD.GE();
    }
}
