package com.baidu.tbadk.j;

import com.baidu.tbadk.j.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e aGd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aGd = eVar;
    }

    @Override // com.baidu.tbadk.j.j.a
    public void fb(int i) {
        j jVar;
        j jVar2;
        jVar = this.aGd.aFX;
        jVar.a((j.a) null);
        jVar2 = this.aGd.aFX;
        jVar2.stop();
        this.aGd.aFZ = i;
        ac acVar = (ac) aa.GG().fg(this.aGd.mSubType);
        if (acVar != null) {
            acVar.h(this.aGd);
        }
    }
}
