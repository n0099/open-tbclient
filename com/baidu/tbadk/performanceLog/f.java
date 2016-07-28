package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e ayG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.ayG = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.j.a
    public void eN(int i) {
        j jVar;
        j jVar2;
        jVar = this.ayG.ayA;
        jVar.a((j.a) null);
        jVar2 = this.ayG.ayA;
        jVar2.stop();
        this.ayG.ayC = i;
        ac acVar = (ac) aa.EV().eS(this.ayG.aza);
        if (acVar != null) {
            acVar.h(this.ayG);
        }
    }
}
