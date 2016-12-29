package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e aBB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aBB = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.j.a
    public void fd(int i) {
        j jVar;
        j jVar2;
        jVar = this.aBB.aBv;
        jVar.a((j.a) null);
        jVar2 = this.aBB.aBv;
        jVar2.stop();
        this.aBB.aBx = i;
        ac acVar = (ac) aa.FU().fi(this.aBB.aBV);
        if (acVar != null) {
            acVar.h(this.aBB);
        }
    }
}
