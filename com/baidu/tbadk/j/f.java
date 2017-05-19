package com.baidu.tbadk.j;

import com.baidu.tbadk.j.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e aGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aGh = eVar;
    }

    @Override // com.baidu.tbadk.j.j.a
    public void eX(int i) {
        j jVar;
        j jVar2;
        jVar = this.aGh.aGb;
        jVar.a((j.a) null);
        jVar2 = this.aGh.aGb;
        jVar2.stop();
        this.aGh.aGd = i;
        ac acVar = (ac) aa.FK().fc(this.aGh.mSubType);
        if (acVar != null) {
            acVar.h(this.aGh);
        }
    }
}
