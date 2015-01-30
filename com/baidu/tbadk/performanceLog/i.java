package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements q {
    final /* synthetic */ h agt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.agt = hVar;
    }

    @Override // com.baidu.tbadk.performanceLog.q
    public void dU(int i) {
        n nVar;
        n nVar2;
        nVar = this.agt.ago;
        nVar.a((q) null);
        nVar2 = this.agt.ago;
        nVar2.stop();
        this.agt.agq = i;
        ae aeVar = (ae) ac.zy().dZ(this.agt.mSubType);
        if (aeVar != null) {
            aeVar.h(this.agt);
        }
    }
}
