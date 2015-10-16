package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e awT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.awT = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.j.a
    public void ew(int i) {
        j jVar;
        j jVar2;
        jVar = this.awT.awO;
        jVar.a((j.a) null);
        jVar2 = this.awT.awO;
        jVar2.stop();
        this.awT.awQ = i;
        aa aaVar = (aa) y.Eb().eB(this.awT.mSubType);
        if (aaVar != null) {
            aaVar.h(this.awT);
        }
    }
}
