package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.debug.a.g {
    final /* synthetic */ a YI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.YI = aVar;
    }

    @Override // com.baidu.adp.lib.debug.a.g
    public void r(int i) {
        int i2;
        int i3;
        int i4;
        com.baidu.adp.lib.debug.a.e eVar;
        com.baidu.adp.lib.debug.a.e eVar2;
        a aVar = this.YI;
        i2 = aVar.YG;
        aVar.YG = i2 + 1;
        i3 = this.YI.YB;
        i4 = this.YI.YG;
        if (i3 == i4) {
            eVar = this.YI.YE;
            eVar.a((com.baidu.adp.lib.debug.a.g) null);
            eVar2 = this.YI.YE;
            eVar2.stop();
            this.YI.uC();
        }
        this.YI.dk(i);
    }
}
