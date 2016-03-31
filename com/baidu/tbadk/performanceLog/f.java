package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e aAX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aAX = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.j.a
    public void fe(int i) {
        j jVar;
        j jVar2;
        jVar = this.aAX.aAR;
        jVar.a((j.a) null);
        jVar2 = this.aAX.aAR;
        jVar2.stop();
        this.aAX.aAT = i;
        ac acVar = (ac) aa.GU().fj(this.aAX.aBr);
        if (acVar != null) {
            acVar.h(this.aAX);
        }
    }
}
