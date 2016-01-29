package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e aAi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aAi = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.j.a
    public void eW(int i) {
        j jVar;
        j jVar2;
        jVar = this.aAi.aAc;
        jVar.a((j.a) null);
        jVar2 = this.aAi.aAc;
        jVar2.stop();
        this.aAi.aAe = i;
        ac acVar = (ac) aa.FY().fb(this.aAi.aAC);
        if (acVar != null) {
            acVar.h(this.aAi);
        }
    }
}
