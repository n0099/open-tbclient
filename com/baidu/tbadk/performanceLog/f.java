package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e aAt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aAt = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.j.a
    public void fe(int i) {
        j jVar;
        j jVar2;
        jVar = this.aAt.aAn;
        jVar.a((j.a) null);
        jVar2 = this.aAt.aAn;
        jVar2.stop();
        this.aAt.aAp = i;
        ac acVar = (ac) aa.FO().fj(this.aAt.aAN);
        if (acVar != null) {
            acVar.h(this.aAt);
        }
    }
}
