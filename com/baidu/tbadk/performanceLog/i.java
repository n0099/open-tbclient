package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements q {
    final /* synthetic */ h agq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.agq = hVar;
    }

    @Override // com.baidu.tbadk.performanceLog.q
    public void dU(int i) {
        n nVar;
        n nVar2;
        nVar = this.agq.agl;
        nVar.a((q) null);
        nVar2 = this.agq.agl;
        nVar2.stop();
        this.agq.agn = i;
        ae aeVar = (ae) ac.zs().dZ(this.agq.mSubType);
        if (aeVar != null) {
            aeVar.h(this.agq);
        }
    }
}
