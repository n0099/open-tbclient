package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e awL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.awL = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.j.a
    public void en(int i) {
        j jVar;
        j jVar2;
        jVar = this.awL.awG;
        jVar.a((j.a) null);
        jVar2 = this.awL.awG;
        jVar2.stop();
        this.awL.awI = i;
        aa aaVar = (aa) y.Ee().es(this.awL.mSubType);
        if (aaVar != null) {
            aaVar.h(this.awL);
        }
    }
}
