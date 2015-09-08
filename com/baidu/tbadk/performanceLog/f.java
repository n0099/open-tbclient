package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e ayt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.ayt = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.j.a
    public void ev(int i) {
        j jVar;
        j jVar2;
        jVar = this.ayt.ayo;
        jVar.a((j.a) null);
        jVar2 = this.ayt.ayo;
        jVar2.stop();
        this.ayt.ayq = i;
        aa aaVar = (aa) y.Eo().eA(this.ayt.mSubType);
        if (aaVar != null) {
            aaVar.h(this.ayt);
        }
    }
}
