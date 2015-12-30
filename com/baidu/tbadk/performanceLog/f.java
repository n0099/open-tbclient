package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e azr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.azr = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.j.a
    public void eC(int i) {
        j jVar;
        j jVar2;
        jVar = this.azr.azl;
        jVar.a((j.a) null);
        jVar2 = this.azr.azl;
        jVar2.stop();
        this.azr.azn = i;
        aa aaVar = (aa) y.EH().eH(this.azr.mSubType);
        if (aaVar != null) {
            aaVar.h(this.azr);
        }
    }
}
