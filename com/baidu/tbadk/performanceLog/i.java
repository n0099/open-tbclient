package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements q {
    final /* synthetic */ h aoT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aoT = hVar;
    }

    @Override // com.baidu.tbadk.performanceLog.q
    public void dY(int i) {
        n nVar;
        n nVar2;
        nVar = this.aoT.aoO;
        nVar.a((q) null);
        nVar2 = this.aoT.aoO;
        nVar2.stop();
        this.aoT.aoQ = i;
        aj ajVar = (aj) ah.CQ().ed(this.aoT.mSubType);
        if (ajVar != null) {
            ajVar.h(this.aoT);
        }
    }
}
