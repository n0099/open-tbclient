package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements q {
    final /* synthetic */ h apY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.apY = hVar;
    }

    @Override // com.baidu.tbadk.performanceLog.q
    public void ei(int i) {
        n nVar;
        n nVar2;
        nVar = this.apY.apT;
        nVar.a((q) null);
        nVar2 = this.apY.apT;
        nVar2.stop();
        this.apY.apV = i;
        aj ajVar = (aj) ah.DC().en(this.apY.mSubType);
        if (ajVar != null) {
            ajVar.h(this.apY);
        }
    }
}
