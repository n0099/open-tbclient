package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements c {
    final /* synthetic */ h aoL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.aoL = hVar;
    }

    @Override // com.baidu.tbadk.performanceLog.c
    public void dY(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        h hVar = this.aoL;
        i2 = hVar.aoJ;
        hVar.aoJ = i2 + 1;
        i3 = this.aoL.aoE;
        i4 = this.aoL.aoJ;
        if (i3 == i4) {
            aVar = this.aoL.aoH;
            aVar.a((c) null);
            aVar2 = this.aoL.aoH;
            aVar2.stop();
            this.aoL.Ct();
        }
        this.aoL.dZ(i);
    }
}
