package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements c {
    final /* synthetic */ h agq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.agq = hVar;
    }

    @Override // com.baidu.tbadk.performanceLog.c
    public void dU(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        h hVar = this.agq;
        i2 = hVar.ago;
        hVar.ago = i2 + 1;
        i3 = this.agq.agj;
        i4 = this.agq.ago;
        if (i3 == i4) {
            aVar = this.agq.agm;
            aVar.a((c) null);
            aVar2 = this.agq.agm;
            aVar2.stop();
            this.agq.zf();
        }
        this.agq.dV(i);
    }
}
