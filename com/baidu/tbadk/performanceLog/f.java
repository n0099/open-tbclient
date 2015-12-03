package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e axN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.axN = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.j.a
    public void eI(int i) {
        j jVar;
        j jVar2;
        jVar = this.axN.axH;
        jVar.a((j.a) null);
        jVar2 = this.axN.axH;
        jVar2.stop();
        this.axN.axJ = i;
        aa aaVar = (aa) y.ES().eN(this.axN.mSubType);
        if (aaVar != null) {
            aaVar.h(this.axN);
        }
    }
}
