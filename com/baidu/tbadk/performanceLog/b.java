package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements j {
    final /* synthetic */ a YE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.YE = aVar;
    }

    @Override // com.baidu.tbadk.performanceLog.j
    public void r(int i) {
        g gVar;
        g gVar2;
        gVar = this.YE.Yz;
        gVar.a((j) null);
        gVar2 = this.YE.Yz;
        gVar2.stop();
        this.YE.YB = i;
        x xVar = (x) v.uN().dp(this.YE.mSubType);
        if (xVar != null) {
            xVar.h(this.YE);
        }
    }
}
