package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e awS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.awS = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.j.a
    public void ew(int i) {
        j jVar;
        j jVar2;
        jVar = this.awS.awN;
        jVar.a((j.a) null);
        jVar2 = this.awS.awN;
        jVar2.stop();
        this.awS.awP = i;
        aa aaVar = (aa) y.Eb().eB(this.awS.mSubType);
        if (aaVar != null) {
            aaVar.h(this.awS);
        }
    }
}
