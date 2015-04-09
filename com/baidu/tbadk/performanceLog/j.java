package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements c {
    final /* synthetic */ h aoT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.aoT = hVar;
    }

    @Override // com.baidu.tbadk.performanceLog.c
    public void dY(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        h hVar = this.aoT;
        i2 = hVar.aoR;
        hVar.aoR = i2 + 1;
        i3 = this.aoT.aoM;
        i4 = this.aoT.aoR;
        if (i3 == i4) {
            aVar = this.aoT.aoP;
            aVar.a((c) null);
            aVar2 = this.aoT.aoP;
            aVar2.stop();
            this.aoT.Cz();
        }
        this.aoT.dZ(i);
    }
}
