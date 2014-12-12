package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements com.baidu.tbadk.coreExtra.view.b {
    final /* synthetic */ bq aFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bq bqVar) {
        this.aFg = bqVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void tn() {
        com.baidu.tbadk.core.data.i iVar;
        com.baidu.tbadk.core.data.i iVar2;
        iVar = this.aFg.aEO;
        if (iVar != null) {
            iVar2 = this.aFg.aEO;
            if (iVar2.getType() == 2) {
                this.aFg.Gc();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void to() {
        this.aFg.GJ();
    }
}
