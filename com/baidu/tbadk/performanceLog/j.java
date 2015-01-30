package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements c {
    final /* synthetic */ h agt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.agt = hVar;
    }

    @Override // com.baidu.tbadk.performanceLog.c
    public void dU(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        h hVar = this.agt;
        i2 = hVar.agr;
        hVar.agr = i2 + 1;
        i3 = this.agt.agm;
        i4 = this.agt.agr;
        if (i3 == i4) {
            aVar = this.agt.agp;
            aVar.a((c) null);
            aVar2 = this.agt.agp;
            aVar2.stop();
            this.agt.zl();
        }
        this.agt.dV(i);
    }
}
