package com.baidu.tbadk.j;

import com.baidu.tbadk.j.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e aFU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aFU = eVar;
    }

    @Override // com.baidu.tbadk.j.j.a
    public void eY(int i) {
        j jVar;
        j jVar2;
        jVar = this.aFU.aFO;
        jVar.a((j.a) null);
        jVar2 = this.aFU.aFO;
        jVar2.stop();
        this.aFU.aFQ = i;
        ac acVar = (ac) aa.FE().fd(this.aFU.mSubType);
        if (acVar != null) {
            acVar.h(this.aFU);
        }
    }
}
