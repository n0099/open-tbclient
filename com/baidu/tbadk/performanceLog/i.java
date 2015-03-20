package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements q {
    final /* synthetic */ h aoL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aoL = hVar;
    }

    @Override // com.baidu.tbadk.performanceLog.q
    public void dY(int i) {
        n nVar;
        n nVar2;
        nVar = this.aoL.aoG;
        nVar.a((q) null);
        nVar2 = this.aoL.aoG;
        nVar2.stop();
        this.aoL.aoI = i;
        aj ajVar = (aj) ah.CK().ed(this.aoL.mSubType);
        if (ajVar != null) {
            ajVar.h(this.aoL);
        }
    }
}
