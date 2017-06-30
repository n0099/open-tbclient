package com.baidu.tbadk.j;

import com.baidu.tbadk.j.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e aHi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aHi = eVar;
    }

    @Override // com.baidu.tbadk.j.j.a
    public void fa(int i) {
        j jVar;
        j jVar2;
        jVar = this.aHi.aHc;
        jVar.a((j.a) null);
        jVar2 = this.aHi.aHc;
        jVar2.stop();
        this.aHi.aHe = i;
        ac acVar = (ac) aa.Gb().ff(this.aHi.mSubType);
        if (acVar != null) {
            acVar.h(this.aHi);
        }
    }
}
