package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e avI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.avI = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.j.a
    public void eu(int i) {
        j jVar;
        j jVar2;
        jVar = this.avI.avC;
        jVar.a((j.a) null);
        jVar2 = this.avI.avC;
        jVar2.stop();
        this.avI.avE = i;
        aa aaVar = (aa) y.DR().ez(this.avI.mSubType);
        if (aaVar != null) {
            aaVar.h(this.avI);
        }
    }
}
