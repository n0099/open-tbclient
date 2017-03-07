package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ e aFL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aFL = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.j.a
    public void eY(int i) {
        j jVar;
        j jVar2;
        jVar = this.aFL.aFF;
        jVar.a((j.a) null);
        jVar2 = this.aFL.aFF;
        jVar2.stop();
        this.aFL.aFH = i;
        ac acVar = (ac) aa.Gi().fd(this.aFL.aGf);
        if (acVar != null) {
            acVar.h(this.aFL);
        }
    }
}
