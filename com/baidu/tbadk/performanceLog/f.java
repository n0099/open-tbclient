package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e aBq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aBq = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.j.a
    public void fa(int i) {
        j jVar;
        j jVar2;
        jVar = this.aBq.aBk;
        jVar.a((j.a) null);
        jVar2 = this.aBq.aBk;
        jVar2.stop();
        this.aBq.aBm = i;
        ac acVar = (ac) aa.Go().ff(this.aBq.aBK);
        if (acVar != null) {
            acVar.h(this.aBq);
        }
    }
}
