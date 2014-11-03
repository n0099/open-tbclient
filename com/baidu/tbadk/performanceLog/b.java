package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements j {
    final /* synthetic */ a YI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.YI = aVar;
    }

    @Override // com.baidu.tbadk.performanceLog.j
    public void r(int i) {
        g gVar;
        g gVar2;
        gVar = this.YI.YD;
        gVar.a((j) null);
        gVar2 = this.YI.YD;
        gVar2.stop();
        this.YI.YF = i;
        x xVar = (x) v.uP().dp(this.YI.mSubType);
        if (xVar != null) {
            xVar.h(this.YI);
        }
    }
}
