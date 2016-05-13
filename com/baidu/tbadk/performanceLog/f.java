package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e axa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.axa = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.j.a
    public void eI(int i) {
        j jVar;
        j jVar2;
        jVar = this.axa.awU;
        jVar.a((j.a) null);
        jVar2 = this.axa.awU;
        jVar2.stop();
        this.axa.awW = i;
        ac acVar = (ac) aa.EN().eN(this.axa.axu);
        if (acVar != null) {
            acVar.h(this.axa);
        }
    }
}
