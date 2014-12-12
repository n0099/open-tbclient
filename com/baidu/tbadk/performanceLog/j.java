package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements c {
    final /* synthetic */ h afV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.afV = hVar;
    }

    @Override // com.baidu.tbadk.performanceLog.c
    public void dO(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        h hVar = this.afV;
        i2 = hVar.afT;
        hVar.afT = i2 + 1;
        i3 = this.afV.afO;
        i4 = this.afV.afT;
        if (i3 == i4) {
            aVar = this.afV.afR;
            aVar.a((c) null);
            aVar2 = this.afV.afR;
            aVar2.stop();
            this.afV.yU();
        }
        this.afV.dP(i);
    }
}
