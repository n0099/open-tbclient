package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements c {
    final /* synthetic */ h apY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.apY = hVar;
    }

    @Override // com.baidu.tbadk.performanceLog.c
    public void ei(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        h hVar = this.apY;
        i2 = hVar.apW;
        hVar.apW = i2 + 1;
        i3 = this.apY.apR;
        i4 = this.apY.apW;
        if (i3 == i4) {
            aVar = this.apY.apU;
            aVar.a((c) null);
            aVar2 = this.apY.apU;
            aVar2.stop();
            this.apY.Dl();
        }
        this.apY.ej(i);
    }
}
