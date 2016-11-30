package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e aCh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aCh = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.j.a
    public void fd(int i) {
        j jVar;
        j jVar2;
        jVar = this.aCh.aCb;
        jVar.a((j.a) null);
        jVar2 = this.aCh.aCb;
        jVar2.stop();
        this.aCh.aCd = i;
        ac acVar = (ac) aa.Gu().fi(this.aCh.aCB);
        if (acVar != null) {
            acVar.h(this.aCh);
        }
    }
}
