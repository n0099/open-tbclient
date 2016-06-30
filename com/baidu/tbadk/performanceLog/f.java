package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e axQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.axQ = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.j.a
    public void eN(int i) {
        j jVar;
        j jVar2;
        jVar = this.axQ.axK;
        jVar.a((j.a) null);
        jVar2 = this.axQ.axK;
        jVar2.stop();
        this.axQ.axM = i;
        ac acVar = (ac) aa.EW().eS(this.axQ.ayk);
        if (acVar != null) {
            acVar.h(this.axQ);
        }
    }
}
