package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.debug.a.g {
    final /* synthetic */ a YE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.YE = aVar;
    }

    @Override // com.baidu.adp.lib.debug.a.g
    public void r(int i) {
        int i2;
        int i3;
        int i4;
        com.baidu.adp.lib.debug.a.e eVar;
        com.baidu.adp.lib.debug.a.e eVar2;
        a aVar = this.YE;
        i2 = aVar.YC;
        aVar.YC = i2 + 1;
        i3 = this.YE.Yx;
        i4 = this.YE.YC;
        if (i3 == i4) {
            eVar = this.YE.YA;
            eVar.a((com.baidu.adp.lib.debug.a.g) null);
            eVar2 = this.YE.YA;
            eVar2.stop();
            this.YE.uA();
        }
        this.YE.dk(i);
    }
}
