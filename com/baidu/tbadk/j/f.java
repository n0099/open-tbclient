package com.baidu.tbadk.j;

import com.baidu.tbadk.j.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e aGb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aGb = eVar;
    }

    @Override // com.baidu.tbadk.j.j.a
    public void fb(int i) {
        j jVar;
        j jVar2;
        jVar = this.aGb.aFV;
        jVar.a((j.a) null);
        jVar2 = this.aGb.aFV;
        jVar2.stop();
        this.aGb.aFX = i;
        ac acVar = (ac) aa.GG().fg(this.aGb.mSubType);
        if (acVar != null) {
            acVar.h(this.aGb);
        }
    }
}
