package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e aBN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aBN = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.j.a
    public void fb(int i) {
        j jVar;
        j jVar2;
        jVar = this.aBN.aBH;
        jVar.a((j.a) null);
        jVar2 = this.aBN.aBH;
        jVar2.stop();
        this.aBN.aBJ = i;
        ac acVar = (ac) aa.Gp().fg(this.aBN.aCh);
        if (acVar != null) {
            acVar.h(this.aBN);
        }
    }
}
