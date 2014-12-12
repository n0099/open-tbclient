package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements q {
    final /* synthetic */ h afV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.afV = hVar;
    }

    @Override // com.baidu.tbadk.performanceLog.q
    public void dO(int i) {
        n nVar;
        n nVar2;
        nVar = this.afV.afQ;
        nVar.a((q) null);
        nVar2 = this.afV.afQ;
        nVar2.stop();
        this.afV.afS = i;
        ae aeVar = (ae) ac.zh().dT(this.afV.mSubType);
        if (aeVar != null) {
            aeVar.h(this.afV);
        }
    }
}
