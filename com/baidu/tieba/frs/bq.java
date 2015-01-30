package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements com.baidu.tbadk.coreExtra.view.b {
    final /* synthetic */ bp aGj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar) {
        this.aGj = bpVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void tE() {
        com.baidu.tbadk.core.data.j jVar;
        com.baidu.tbadk.core.data.j jVar2;
        jVar = this.aGj.aFR;
        if (jVar != null) {
            jVar2 = this.aGj.aFR;
            if (jVar2.getType() == 2) {
                this.aGj.Gz();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void tF() {
        this.aGj.Hg();
    }
}
