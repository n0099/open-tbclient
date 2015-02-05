package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements com.baidu.tbadk.coreExtra.view.b {
    final /* synthetic */ bp aGg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar) {
        this.aGg = bpVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void ty() {
        com.baidu.tbadk.core.data.j jVar;
        com.baidu.tbadk.core.data.j jVar2;
        jVar = this.aGg.aFO;
        if (jVar != null) {
            jVar2 = this.aGg.aFO;
            if (jVar2.getType() == 2) {
                this.aGg.Gt();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void tz() {
        this.aGg.Ha();
    }
}
